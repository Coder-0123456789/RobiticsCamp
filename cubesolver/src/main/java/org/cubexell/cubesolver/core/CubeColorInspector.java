package org.cubexell.cubesolver.core;

public interface CubeColorInspector {
    void startup();
    char[][][] inspect() throws InterruptedException;
    void shutdown();
}
