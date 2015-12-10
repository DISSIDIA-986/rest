package com.example.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.Book;
import com.example.domain.Books;
import com.example.service.BookService;

/**
 * <p>BookResource class.</p>
 *
 * @author hanl
 * @version $Id: $Id
 */
@Path("books")
public class BookResource {
	private static final Logger LOGGER = Logger.getLogger(BookResource.class);
	
	@Autowired 
	private BookService bookService;
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Books getBooks(){
		final Books books = bookService.getBooks();
		BookResource.LOGGER.debug(books);
		return books;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("{bookId:[0-9]*}")
	public Book getBookByPath(@PathParam("bookId") long bookId){
		final Book book = bookService.getBook(bookId);
		BookResource.LOGGER.debug(book);
		return book;
	}
	
	
	@Path("/book")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Book getBookByQuery(@QueryParam("id") final long bookId){
		final Book book = bookService.getBook(bookId);
		BookResource.LOGGER.debug(book);
		return book;
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public Book saveBook(final Book book){
		return bookService.saveBook(book);
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	@Path("{bookId:[0-9]*}")
	public Book updateBook(@PathParam("bookId") final long bookId,final Book book){
		if(book==null){
			return book;
		}
		return bookService.updateBook(bookId, book);
	}
	
	@DELETE
	@PathParam("{bookId:[0-9]*}")
	public String deleteBook(@PathParam("bookId") final long bookId){
		if(bookService.deleteBook(bookId)){
			return "Deleted book id=" + bookId;
		}else{
			return "Deleted book failed id=" + bookId;
		}
	}
}