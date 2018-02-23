package kr.rvs.instrumentation;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.ATHROW;
import static org.objectweb.asm.Opcodes.DRETURN;
import static org.objectweb.asm.Opcodes.FRETURN;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.LRETURN;
import static org.objectweb.asm.Opcodes.RETURN;

/**
 * Created by USER on 2018-02-19.
 */
public class TransformMethodVisitor extends MethodVisitor {
    public TransformMethodVisitor(int api, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
    }

    @Override
    public void visitInsn(int opcode) {
        switch (opcode) {
            case ARETURN:
            case DRETURN:
            case FRETURN:
            case IRETURN:
            case LRETURN:
            case RETURN:
            case ATHROW:
                visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                visitLdcInsn("Exception detected");
                visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            default:
                break;
        }

        super.visitInsn(opcode);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }
}
