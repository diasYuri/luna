package src.types.pool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Supplier;

public class ObjectPool<T extends Collectable> {
    private final Queue<T> pool;
    private final Supplier<T> supplier;
    private final int size;
    public ObjectPool(int sizePool, Supplier<T> supplier) {
        this.pool = new ArrayDeque<>(sizePool);
        this.size = sizePool;
        this.supplier = supplier;
    }

    public T get(){
        if(this.pool.isEmpty()){
            return supplier.get();
        }
        return this.pool.poll();
    }

    public void giveBack(T instance){
        if(this.pool.size() < this.size){
            pool.add(instance);
        }
    }
}
