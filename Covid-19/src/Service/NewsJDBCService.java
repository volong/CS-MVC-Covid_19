package Service;

import Model.News;

import java.util.List;

public interface NewsJDBCService<T> {
    List<T> findAll();

    T findById(int id);

    void save(News news);

    void update(int id, News news);

    void remove(int id);


}
