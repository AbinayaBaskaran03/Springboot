package com.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onetomany.entity.Author;
import com.onetomany.entity.Book1;
import com.onetomany.entity.Book2;
import com.onetomany.entity.Book3;
import com.onetomany.entity.PasswordUtil;
import com.onetomany.repository.AuthorRepository;
import com.onetomany.repository.Book1Repository;
import com.onetomany.repository.Book2Repository;
import com.onetomany.repository.Book3Repository;
@Service
public class AuthorBookService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private Book1Repository book1Repository;
	
	@Autowired
	private Book2Repository book2Repository;
	
	@Autowired
	private Book3Repository book3Repository;
	
	public void saveAuthor(Author author) {
		Author authorObj = authorRepository.save(author);
		
		String idObj = PasswordUtil.getPassword(author.getAuthorCode());
		
		Book1 book1Obj = new Book1();
		book1Obj.setBook1Id(authorObj.getAuthorId());
		book1Obj.setBook1Title("The Mystery of the Lost Key");
		book1Obj.setBook1Price("550");
		book1Obj.setBook1Pswd(idObj);
		
		Book2 book2Obj = new Book2();
		book2Obj.setBook2Id(authorObj.getAuthorId());
		book2Obj.setBook2Title("A Journey Through Time");
		book2Obj.setBook2Price("459");
		book2Obj.setBook2Pswd(idObj);


		Book3 book3Obj = new Book3();
		book3Obj.setBook3Id(authorObj.getAuthorId());
		book3Obj.setBook3Title("Secrets of the Hidden Forest");
		book3Obj.setBook3Price("250");
		book3Obj.setBook3Pswd(idObj);

		
		book1Repository.save(book1Obj);
		book2Repository.save(book2Obj);
    	book3Repository.save(book3Obj);
	
	}
}
