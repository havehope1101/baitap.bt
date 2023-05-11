//package com.example.baitapbt4.pokeRepository;
//
//import com.example.baitapbt4.entity.PokeEntity;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.PagingAndSortingRepository;
//
//import java.util.List;
//
//public interface PagingAndSortingPoke extends PagingAndSortingRepository<PokeEntity,Long> {
//
//    Sort atk = Sort.by("attack");
//    Sort def = Sort.by("defend");
//    Sort spAtk = Sort.by("sp.atk");
//    Sort spDef = Sort.by("sp.def");
//    Sort hp = Sort.by("hp");
//    Sort total = Sort.by("total");
//    Sort groupBySort = atk.and(def).and(spAtk).and(spDef).and(hp).and(total);
//
//    List<PokeEntity> list = PagingAndSortingPoke.findAll(groupBySort);
//}
