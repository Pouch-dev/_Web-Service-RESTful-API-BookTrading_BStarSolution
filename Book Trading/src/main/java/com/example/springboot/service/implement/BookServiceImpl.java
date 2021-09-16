package com.example.springboot.service.implement;

import com.example.springboot.entity.Product;
import com.example.springboot.entity.Category;
import com.example.springboot.exception.ApiRequestException;
import com.example.springboot.model.AddProduct;
import com.example.springboot.model.UpdateBook;
import com.example.springboot.repository.BookDAO;
import com.example.springboot.repository.CategoryDAO;
import com.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDAO bookDAO;
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Product> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Product save(AddProduct bookDto) {
        Category category = categoryDAO.findById(bookDto.getCategoryId()).orElseThrow(() ->
                new ApiRequestException(
                        String.format("Not found Category with id = [%d]", bookDto.getCategoryId()))
        );
        Product book = new Product();
        book.convertFromAddBook(bookDto);
        book.setCate(category);
        return bookDAO.save(book);
    }

    @Override
    public Product findById(Integer bookId) {
        return bookDAO.findById(bookId).orElseThrow(() -> new ApiRequestException(
                String.format("Not found book with id = [%d]", bookId)
        ));
    }

    @Override
    public void deleteById(Integer bookId) {
        /*Product book = */bookDAO.findById(bookId).orElseThrow(() -> new ApiRequestException(
                String.format("Not found book with id = [%d]", bookId)
        ));
//        book.setDeletedFlag();
        bookDAO.deleteById(bookId);
    }

    @Override
    public Product updateBook(UpdateBook updateBook) {
        Product book = bookDAO.findById(updateBook.getBookId()).orElseThrow(() -> new ApiRequestException(
                String.format("Not found book with id = [%d]", updateBook.getBookId())
        ));
        book.setBookName(updateBook.getBookName());
        book.setImage(updateBook.getImage());
        book.setIsActive(updateBook.getIsActive());
        return bookDAO.save(book);
    }

    @Override
    public List<Product> findByCateCategoryId(Integer categoryId) {
        List<Product> bookList = bookDAO.findByCateCategoryId(categoryId);
        if (bookList.size() == 0) {
            throw new ApiRequestException(String.format("not found any book with categoryId = [%s]", categoryId));
        }
        return bookList;
    }
}
