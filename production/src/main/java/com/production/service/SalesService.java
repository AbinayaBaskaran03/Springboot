package com.production.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.production.dto.SalesDto;
import com.production.entity.Sales;
import com.production.entity.Transaction;
import com.production.repository.SalesRepository;
import com.production.repository.TransRepository;

@Service
public class SalesService {

	@Autowired
	private SalesRepository salesRepository;

	@Autowired
	private TransRepository transRepository;

	public void createSalesandTrans(SalesDto salesDto) {
		Sales salesObj = new Sales();
		if (salesDto != null) {
			salesObj.setProductId(salesDto.getProductId());
			salesObj.setCusId(salesDto.getCusId());
			
			
			salesObj.setSalesDate(salesDto.getSalesDate());

			salesObj.setPalkova(salesDto.getPalkova() != null ? salesDto.getPalkova() : 0);
			salesObj.setRasagulla(salesDto.getRasagulla() != null ? salesDto.getRasagulla() : 0);
			salesObj.setRasamalai(salesDto.getRasamalai() != null ? salesDto.getRasamalai() : 0);

			Integer totitems = 0;

			if (salesObj.getPalkova() != null) {
				totitems += salesObj.getPalkova();
			}
			if (salesObj.getRasagulla() != null) {
				totitems += salesObj.getRasagulla();
			}
			if (salesObj.getRasamalai() != null) {
				totitems += salesObj.getRasamalai();
			}

			salesObj.setTotItems(totitems);

			double item1Rate = 150.0;
			double item2Rate = 100.0;
			double item3Rate = 80.0;

			salesObj.setPalkovaRate(salesDto.getPalkova() != null ? salesDto.getPalkova() * item1Rate : 0);
			salesObj.setRasagullaRate(salesDto.getRasagulla() != null ? salesDto.getRasagulla() * item2Rate : 0);
			salesObj.setRasamalaiRate(salesDto.getRasamalai() != null ? salesDto.getRasamalai() * item3Rate : 0);

			double totAmount = 0.0;

			if (salesObj.getPalkovaRate() != null) {
				totAmount += salesObj.getPalkovaRate();
			}
			if (salesObj.getRasagullaRate() != null) {
				totAmount += salesObj.getRasagullaRate();
			}
			if (salesObj.getRasamalaiRate() != null) {
				totAmount += salesObj.getRasamalaiRate();
			}

			salesObj.setTotAmount(totAmount);
			salesObj.setStatus(salesDto.getStatus());
			salesRepository.save(salesObj);
		}

		if (salesDto.getTransactionDto() != null) {
			UUID transactionId = UUID.randomUUID();
			Transaction transObj = new Transaction();
			transObj.setId(transactionId);
			transObj.setProductId(salesDto.getTransactionDto().getProductId());
			transObj.setTransDate(salesObj.getSalesDate());
			transObj.setQuantity(30 - salesObj.getTotItems());
			transObj.setStatus(salesDto.getTransactionDto().getStatus());

			transRepository.save(transObj);
		}
	}

	public List<Sales> getAllSales() {
		return salesRepository.findAll();
	}

	public List<Sales> getBycusId(Integer cusId) {
		return salesRepository.findByCusId(cusId);
	}

	public List<Sales> findBydate(Date salesDate) {
		return salesRepository.findAllBySalesDate(salesDate);
	}

}
