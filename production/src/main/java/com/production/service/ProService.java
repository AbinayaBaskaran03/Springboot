//package com.production.service;
//@Service
//public class ProService {
//	package com.production.Service;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.stereotype.Service;
//
//	import com.production.Dto.ProductionDto;
//	import com.production.Entity.Item1;
//	import com.production.Entity.Item2;
//	import com.production.Entity.Item3;
//	import com.production.Entity.Production;
//	import com.production.Repository.Item1Repository;
//	import com.production.Repository.Item2Repository;
//	import com.production.Repository.Item3Repository;
//	import com.production.Repository.ProductionRepository;
//	
//
//
//		@Autowired
//		public ProductionRepository productionRepository;
//		
//		@Autowired
//		public Item1Repository item1Repository;
//		
//		@Autowired
//		public Item2Repository item2Repository;
//		
//		@Autowired
//		public Item3Repository item3Repository;
//
//		public void saveProduction(ProductionDto productionDto) {
//			 Production productionObj = new Production();
//			 productionObj.setId(productionDto.getId());
//			 productionObj.setProductName(productionDto.getProductName());
//			 productionObj.setManuDate(productionDto.getManuDate());
//			 productionObj.setExpDate(productionDto.getExpDate());
//			 productionObj.setReceivedQty(productionDto.getReceivedQty());
//			 productionObj.setStatus(productionDto.getStatus());
//			productionRepository.save(productionObj);
//
//			if (productionDto.getItem1dto() != null) {
//				Item1 item1 = new Item1();
//
//				item1.setId(item1.getId());
//				item1.setProductId(productionObj.getId());
//	            item1.setItemName(productionDto.getItem1dto().getItemName());
//				item1.setItemQty(productionDto.getItem1dto().getItemQty());
//				item1.setPergramRate(productionDto.getItem1dto().getPergramRate());
//				item1.setStatus(productionDto.getItem1dto().getStatus());
//				productionObj.setItem1(item1);
//				item1Repository.save(item1);
//
//			}
//
//			if (productionDto.getItem2dto() != null) {
//				Item2 item2 = new Item2();
//
//				item2.setId(item2.getId());
//				item2.setProductId(productionObj.getId());
//				item2.setItemName(productionDto.getItem2dto().getItemName());
//				item2.setItemQty(productionDto.getItem2dto().getItemQty());
//				item2.setPergramRate(productionDto.getItem2dto().getPergramRate());
//				item2.setStatus(productionDto.getItem2dto().getStatus());
//				productionObj.setItem2(item2);
//				item2Repository.save(item2);
//
//			}
//
//			if (productionDto.getItem3dto() != null) {
//				Item3 item3 = new Item3();
//
//				item3.setId(item3.getId());
//				item3.setProductId(productionObj.getId());
//				item3.setItemName(productionDto.getItem3dto().getItemName());
//				item3.setItemQty(productionDto.getItem3dto().getItemQty());
//				item3.setPergramRate(productionDto.getItem3dto().getPergramRate());
//				item3.setStatus(productionDto.getItem3dto().getStatus());
//				productionObj.setItem3(item3);
//				item3Repository.save(item3);
//
//			}
//		}
//
//	}
//
//			 
//
//
//}
