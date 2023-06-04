package lang.interpreter.types.pool;

import lang.interpreter.types.pointers.RefPointer;

public class ObjectPools {
    private static final ObjectPool<RefPointer> refPointerObjectPool = new ObjectPool<>(50, RefPointer::new);
    public static ObjectPool<RefPointer> GetRefPointerPool(){
        return refPointerObjectPool;
    }
}
