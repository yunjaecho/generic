package kr.rvs.instrumentation;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

/**
 * Created by USER on 2018-02-19.
 */
public class TransformClassVisitor extends ClassVisitor {
    public TransformClassVisitor(int i, ClassWriter classVisitor) {
        super(i, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor visitor = super.visitMethod(access, name, desc, signature, exceptions);

        if (name.equals("<init>")) {
            visitor = new TransformMethodVisitor(api, visitor);
        }

        return visitor;
    }
}
