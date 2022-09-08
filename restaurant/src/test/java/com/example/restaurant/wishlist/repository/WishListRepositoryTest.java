package com.example.restaurant.wishlist.repository;

import com.example.restaurant.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create() {
        WishListEntity wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("readAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitData(null);

        return wishList;
    }


    @Test
    public void saveTest() {
        WishListEntity wishList = create();
        WishListEntity save = wishListRepository.save(wishList);

        Assertions.assertNotNull(save);
        Assertions.assertEquals(1, save.getIndex());
    }

    @Test
    public void updateTest() {
        WishListEntity wishList = create();
        WishListEntity save = wishListRepository.save(wishList);

        save.setTitle("update Title");
        WishListEntity save1 = wishListRepository.save(save);

        Assertions.assertEquals("update Title", save1.getTitle());
        Assertions.assertEquals(1, wishListRepository.listAll().size());


    }

    @Test
    public void findByIdText() {
        WishListEntity wishList = create();
        wishListRepository.save(wishList);

        Optional<WishListEntity> byId = wishListRepository.findById(1);

        Assertions.assertEquals(true, byId.isPresent());
        Assertions.assertEquals(1, byId.get().getIndex());
    }

    @Test
    public void deleteTest() {
        WishListEntity wishList = create();
        wishListRepository.save(wishList);

        wishListRepository.deleteById(1);

        int count = wishListRepository.listAll().size();

        Assertions.assertEquals(0, count);

    }

    @Test
    public void listAll() {
        WishListEntity wishList1 = create();
        wishListRepository.save(wishList1);

        WishListEntity wishList2 = create();
        wishListRepository.save(wishList2);

        int count = wishListRepository.listAll().size();
        Assertions.assertEquals(2, count);
    }
}
