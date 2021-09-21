package com.example.springboot.service.implement;

import com.example.springboot.entity.Product;
import com.example.springboot.entity.Category;
import com.example.springboot.exception.ApiMsiException;
import com.example.springboot.exception.ApiRequestException;
import com.example.springboot.model.AddProduct;
import com.example.springboot.model.UpdateBook;
import com.example.springboot.repository.BookDAO;
import com.example.springboot.repository.CategoryDAO;
import com.example.springboot.service.BookService;
import com.example.springboot.service.ExternalRESTService;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ExternalRESTService implements BookService {

    @Autowired private BookDAO bookDAO;

    @Autowired private CategoryDAO categoryDAO;

    @Autowired private ApiMsiException apiMsiException;

    private static final String HOST_URL_K = "hostUrl";
    private static final String SERVICE_ID = "MLS.OtherService";

    @Override
    public List<Product> findAll() {
        return bookDAO.findAll();
    }

//    @Override
//    public Product save(AddProduct bookDto) {
//        Category category = categoryDAO.findById(bookDto.getCategoryId()).orElseThrow(() ->
//                new ApiRequestException(
//                        String.format("Not found Category with id = [%d]", bookDto.getCategoryId()))
//        );
//        Product book = new Product();
//        book.convertFromAddBook(bookDto);
//        book.setCate(category);
//        return bookDAO.save(book);
//    }

    @Override
    public Product save(AddProduct bookDto) throws ApiRequestException {
        Category response = null;
        Category result = null;
        try{
            result = CallREST(HttpMethod.GET,
                    bookDto,
                    Category.class,
                    this::toError);
            categoryDAO.save(result);
            response = categoryDAO.findById(bookDto.getCategoryId()).orElseThrow(() ->
                    new ApiRequestException(
                            String.format("Not found Category with id = [%d]", bookDto.getCategoryId()))
            );
            Product book = new Product();
            book.convertFromAddBook(bookDto);
            book.setCate(response);
            return bookDAO.save(book);
        }
        catch (ApiRequestException ex){
            throw new ApiRequestException("not found");
        }
    }

    //---------------------------------------------------------------------------------


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


    //---------------------------------------------------------------------------------



    protected String toError(Object response) {
        if (response instanceof StatusLine) {
            if (((StatusLine) response).getStatusCode() != 200)
                return ((StatusLine) response).getReasonPhrase();
            return null;
        }
        throw new ApiRequestException("Unknown error");
    }

    @Override
    public String getHostUrl(Object request, HttpMethod method) {
        String baseHost = apiMsiException.getConfigGroup(SERVICE_ID).get(HOST_URL_K);
        if (HttpMethod.POST == method) return baseHost;
        String param = null;
        if (request instanceof String) {
            param = String.valueOf(request);
            return baseHost.concat("/" + param);
        }
        return baseHost;
    }
}
