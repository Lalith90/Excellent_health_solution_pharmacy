package lk.excellent.pharamacy_management.asset.item.service;

import lk.excellent.pharamacy_management.asset.commonAsset.Enum.Category;
import lk.excellent.pharamacy_management.asset.item.dao.ItemDao;
import lk.excellent.pharamacy_management.asset.item.entity.Item;
import lk.excellent.pharamacy_management.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ItemService implements AbstractService<Item, Integer> {

    private final ItemDao itemDao;

    @Autowired
    public ItemService(ItemDao itemDao) {
        this.itemDao= itemDao;
    }

    @Override
    public List<Item> findAll() {
        return itemDao.findAll();
    }

    @Override
    public Item findById(Integer id) {
        return itemDao.getOne(id);
    }

    @Override
    public Item persist(Item item) {
        return itemDao.save(item);
    }

    @Override
    public boolean delete(Integer id) {
        itemDao.deleteById(id);
        return false;
    }

    @Override
    public List<Item> search(Item item) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Item> itemExample = Example.of(item, matcher);
        return itemDao.findAll(itemExample);
    }

    public Item lastItem(){
        return itemDao.findFirstByOrderByIdDesc();
    }
    public Item findByCode(String code){
        return itemDao.findByCode(code);
    }


    public List<Item> findByCategory(Category category) {
        return itemDao.findByCategory(category);
    }

    public List<Item> findByCreatedAtBetween(LocalDate from, LocalDate to){
        return itemDao.findByCreatedAtBetween(from, to);
    }
}
