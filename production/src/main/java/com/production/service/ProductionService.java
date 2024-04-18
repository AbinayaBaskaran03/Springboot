package com.production.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.production.dto.ProductionDto;
import com.production.entity.Item1;
import com.production.entity.Item2;
import com.production.entity.Item3;
import com.production.entity.Production;
import com.production.entity.Transaction;
import com.production.repository.Item1Repository;
import com.production.repository.Item2Repository;
import com.production.repository.Item3Repository;
import com.production.repository.ProductionRepository;
import com.production.repository.TransRepository;

@Service
public class ProductionService {

	@Autowired
	public ProductionRepository productionRepository;

	@Autowired
	public Item1Repository item1Repository;

	@Autowired
	public Item2Repository item2Repository;

	@Autowired
	public Item3Repository item3Repository;

	@Autowired
	public TransRepository transRepository;

	public void saveProduction(ProductionDto productionDto) {
		Production productionObj = new Production();
		Item1 item1Obj = new Item1();
		Item2 item2Obj = new Item2();
		Item3 item3Obj = new Item3();

		productionObj.setId(productionDto.getId());

		productionObj.setManuDate(productionDto.getManuDate());
		productionObj.setExpDate(productionDto.getExpDate());
		productionObj.setQuantity(productionDto.getQuantity());
		productionObj.setStatus(productionDto.getStatus());

		productionRepository.save(productionObj);

		if (productionDto.getItem1dto() != null) {
			if (item1Obj != null) {
				item1Obj.setId(item1Obj.getId());
				item1Obj.setItem1Name(productionDto.getItem1dto().getItem1Name());
				item1Obj.setItem1Qty(productionDto.getItem1dto().getItem1Qty());
				item1Obj.setEachitemRate(productionDto.getItem1dto().getEachitemRate());
				item1Obj.setStatus(productionDto.getItem1dto().getStatus());
				item1Repository.save(item1Obj);
			}
		}

		if (productionDto.getItem2dto() != null) {
			if (item2Obj != null) {
				item2Obj.setId(item2Obj.getId());
				item2Obj.setItem2Name(productionDto.getItem2dto().getItem2Name());
				item2Obj.setItem2Qty(productionDto.getItem2dto().getItem2Qty());
				item2Obj.setEachitemRate(productionDto.getItem2dto().getEachitemRate());
				item2Obj.setStatus(productionDto.getItem2dto().getStatus());
				item2Repository.save(item2Obj);
			}
		}

		if (productionDto.getItem3dto() != null) {

			if (item3Obj != null) {
				item3Obj.setId(item3Obj.getId());
				item3Obj.setItem3Name(productionDto.getItem3dto().getItem3Name());
				item3Obj.setItem3Qty(productionDto.getItem3dto().getItem3Qty());
				item3Obj.setEachitemRate(productionDto.getItem3dto().getEachitemRate());
				item3Obj.setStatus(productionDto.getItem3dto().getStatus());
				item3Repository.save(item3Obj);
			}
		}
		Transaction transObj = new Transaction();

		if (productionDto.getTransactionDto() != null) {
			transObj.setId(transObj.getId());
			transObj.setProductId(productionObj.getId());
			transObj.setTransDate(productionDto.getTransactionDto().getTransDate());
			transObj.setQuantity(productionDto.getQuantity());
			transObj.setStatus(productionDto.getTransactionDto().getStatus());

			transRepository.save(transObj);
		}

	}
}
