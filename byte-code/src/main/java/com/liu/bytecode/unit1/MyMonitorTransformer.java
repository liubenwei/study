package com.liu.bytecode.unit1;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liu
 * @Date 2020/10/9 10:11
 */
public class MyMonitorTransformer implements ClassFileTransformer {
    public static final Set<String> classNameSet = new HashSet<>();
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        return new byte[0];
    }
}
