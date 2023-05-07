package com.exception.student.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.student.Entity.Book;
import com.exception.student.Entity.User;
import com.exception.student.Repository.BookRepository;
import com.exception.student.Repository.UserRepository;

@RestController
@RequestMapping
public class LibraryController {
	@Autowired
	BookRepository bookrepo;
	@Autowired 
	UserRepository userrepo;
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return ResponseEntity.ok().body(userrepo.save(user));
		
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		Optional<User> opuser=userrepo.findById(id);
				if(opuser.isPresent()) 
				{
					//return ResponseEntity.ok().body(opuser.get());
					return ResponseEntity.ok(opuser.get());
					//return new ResponseEntity<>(opuser.get(),HttpStatus.ACCEPTED);
					//return ResponseEntity.status(HttpStatus.ACCEPTED).body(opuser.get());
				}
				else
				{
					return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
				}
				
	
	}
	@PostMapping("/createbook")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return ResponseEntity.ok().body(bookrepo.save(book));
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id){
		Optional<Book> opb=bookrepo.findById(id);
		if(opb.isPresent()) {
			return ResponseEntity.ok().body(opb.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
	
	
}
