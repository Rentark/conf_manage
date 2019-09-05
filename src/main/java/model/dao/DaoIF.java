package model.dao;

import model.entity.Entity;

import java.util.List;

public interface DaoIF {
    <T extends Entity> List<T> getAll();
    <T extends Entity> int delete(T entity);
    <T extends Entity> int insert(T entity);
    <T extends Entity> T getItemByID(int id);
    <T extends Entity> int update(T entity);
}
