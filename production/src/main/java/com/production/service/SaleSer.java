//package com.production.service;
//
//public class SaleSer {
//	package com.production.Service;
//
//	import java.util.UUID;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.stereotype.Service;
//
//	import com.production.Dto.SalesDto;
//	import com.production.Entity.Item1;
//	import com.production.Entity.Item2;
//	import com.production.Entity.Item3;
//	import com.production.Entity.Sales;
//	import com.production.Entity.Transaction;
//	import com.production.Repository.Item1Repository;
//	import com.production.Repository.Item2Repository;
//	import com.production.Repository.Item3Repository;
//	import com.production.Repository.SalesRepository;
//	import com.production.Repository.TransRepository;
//
//	@Service
//	public class SalesServices {
//		@Autowired
//		public SalesRepository  salesRepository;
//		
//		@Autowired
//		public  TransRepository   transRepository;
//		
//		@Autowired
//		public  Item1Repository   item1Repository;
//		
//		@Autowired
//		public  Item2Repository   item2Repository;
//		
//		@Autowired
//		public  Item3Repository  item3Repository;
//		
//		
//
//		public void saveProduction(SalesDto salesDto) {
//			Sales salesObj = new Sales();
//
//			salesObj.setId(salesDto.getId());
//			salesObj.setCusId(salesDto.getCusId());
//
//			UUID item1Id = salesDto.getItem1Id();
//			UUID item2Id = salesDto.getItem2Id();
//			UUID item3Id = salesDto.getItem3Id();
//			if (item1Id != null) {
//				Item1 item1Obj = item1Repository.findById(item1Id).orElse(null);
//				if (item1Obj != null) {
//					salesObj.setItem1Id(item1Obj.getId());
//					salesObj.setItem1Name(salesDto.getItem1Name());
//					salesObj.setItem1Gram(salesDto.getItem1Gram());
//					if (salesDto.getItem1Gram() != null) {
//						salesObj.setItem1Gramrate(salesDto.getItem1Gram() * item1Obj.getPergramRate());
//					} else {
//						salesObj.setItem1Gramrate(0.0);
//					}
//				} 
//			
//			if (item2Id != null) {
//				Item2 item2Obj = item2Repository.findById(item2Id).orElse(null);
//				if (item2Obj != null) {
//					salesObj.setItem2Id(item2Obj.getId());
//					salesObj.setItem2Name(salesDto.getItem2Name());
//					salesObj.setItem2Gram(salesDto.getItem2Gram());
//					if (salesDto.getItem2Gram() != null) {
//						salesObj.setItem2Gramrate(salesDto.getItem2Gram() * item2Obj.getPergramRate());
//					} else {
//						salesObj.setItem2Gramrate(0.0);
//					}
//				} 
//			
//			if (item3Id != null) {
//				Item3 item3Obj = item3Repository.findById(item3Id).orElse(null);
//				if (item3Obj != null) {
//					salesObj.setItem3Id(item3Obj.getId());
//					salesObj.setItem3Name(salesDto.getItem3Name());
//					salesObj.setItem3Gram(salesDto.getItem3Gram());
//					if (salesDto.getItem3Gram() != null) {
//						salesObj.setItem3Gramrate(salesDto.getItem3Gram() * item3Obj.getPergramRate());
//					} else {
//						salesObj.setItem3Gramrate(0.0);
//					}
//				} 
//			
//			
//			double totalAmount = 0.0;
//			if (salesObj.getItem1Gramrate() != null) {
//				totalAmount += salesObj.getItem1Gramrate();
//			}
//			if (salesObj.getItem2Gramrate() != null) {
//				totalAmount += salesObj.getItem2Gramrate();
//			}
//			if (salesObj.getItem3Gramrate() != null) {
//				totalAmount += salesObj.getItem3Gramrate();
//			}
//			salesObj.setTotAmount(totalAmount);
//
//			salesObj.setStatus(salesDto.getStatus());
//
//			salesRepository.save(salesObj);
//			
//			Transaction transObj = new Transaction();
//			
//			if(salesDto.getTransDto() !=null) {
//			
//			transObj.setId(transObj.getId());
//			transObj.setSalesId(salesObj.getId());
//			
//			transObj.setItem1Id(salesObj.getItem1Id());
//			transObj.setItem2Id(salesObj.getItem2Id());
//			transObj.setItem3Id(salesObj.getItem3Id());
//			
//			transObj.setItem1Name(item1Obj.getItemName());
//			transObj.setItem2Name(item2Obj.getItemName());
//			transObj.setItem3Name(item3Obj.getItemName());
//			
//			if (salesDto.getItem1Gram() != null) {
//				transObj.setItem1Sold(salesObj.getItem1Gram());
//			} else {
//				transObj.setItem1Sold(0.0);
//			}
//			
//			if (salesDto.getItem1Gram() != null) {
//				transObj.setItem2Sold(salesObj.getItem2Gram());
//			} else {
//				transObj.setItem2Sold(0.0);
//			}
//			
//			if (salesDto.getItem1Gram() != null) {
//				transObj.setItem3Sold(salesObj.getItem3Gram());
//			} else {
//				transObj.setItem3Sold(0.0);
//			}
//			
//			 if (transObj.getItem1Sold() != null) {
//	             transObj.setItem1Bal(item1Obj.getItemQty() - transObj.getItem1Sold());
//	         }else {
//	        	 transObj.setItem1Bal(0.0);
//	         }
//
//	         if (transObj.getItem2Sold() != null) {
//	             transObj.setItem2Bal(item2Obj.getItemQty() - transObj.getItem2Sold());
//	         }else {
//	        	 transObj.setItem2Bal(0.0);
//	         }
//
//	         if (transObj.getItem2Sold() != null) {
//	             transObj.setItem3Bal(item3Obj.getItemQty() - transObj.getItem3Sold());
//	         }else {
//	        	 transObj.setItem3Bal(0.0);
//	         }
//			
//			transObj.setStatus(salesDto.getTransDto().getStatus());
//			
//			}
//			transRepository.save(transObj);
//
//			}
//			}
//			}
//
//		}
//	}
//}
