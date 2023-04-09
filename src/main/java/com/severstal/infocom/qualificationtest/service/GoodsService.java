package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Goods;
import com.severstal.infocom.qualificationtest.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsService implements IGoodsService {
    private final GoodsRepository goodsRepository;

    @Override
    @Transactional
    public Goods create(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public Goods get(Long id) {
        return goodsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<Goods> getAll() {
        return goodsRepository.findAll();
    }

    @Override
    public Goods update(Goods Goods) {
        return create(Goods);
    }

    @Override
    public void delete(Goods Goods) {
        goodsRepository.delete(Goods);
    }

    @Override
    public void delete(Long id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        goodsRepository.deleteAllById(ids);
    }

}
