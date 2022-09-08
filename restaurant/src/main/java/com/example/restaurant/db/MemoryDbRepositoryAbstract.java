package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) {

        Optional<T> optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if (optionalEntity.isEmpty()) {
            // db에 데이터가 없는 경우
            this.index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;


        } else {
            // db에 이미 데이터가 있는 경우
            int preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;
        }
    }

    @Override
    public void deleteById(int index) {

        Optional<T> optionalT = db.stream().filter(it -> it.getIndex() == index).findFirst();
        if (optionalT.isPresent()) {
            db.remove(optionalT.get());
        }
    }

    @Override
    public List<T> listAll() {
        return db;
    }
}
