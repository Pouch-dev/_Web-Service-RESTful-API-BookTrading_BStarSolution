//package com.example.springboot.service;
//
//import com.example.springboot.entity.Category;
//import com.example.springboot.entity.Product;
//import com.example.springboot.exception.ApiRequestException;
//import com.example.springboot.model.AddProduct;
//import com.example.springboot.model.UpdateBook;
//import com.example.springboot.repository.BookDAO;
//import com.example.springboot.repository.CategoryDAO;
//import org.apache.http.StatusLine;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//
//import java.util.List;
//
//public class InfoService extends ExternalRESTService implements BookService{
//
//
//    @Autowired private BookDAO bookDAO;
//    @Autowired private CategoryDAO categoryDAO;
//
//
//
//    @Override
//    protected CloseableHttpClient getREST(String hostUrl) {
//        return null;
//    }
//
//    @Override
//    protected HttpUriRequest buildGetRequest(String hostUrl, Integer timeout) {
//        return null;
//    }
//
//
//    @Override
//    protected String getHostUrl(Object request, HttpMethod method) {
//        return null;
//    }
//
//
//
//
//    @Override
//    public Product save(AddProduct bookDto) throws ApiRequestException {
//        Category response = null;
//        Category result = null;
//        try{
//            result = CallREST(HttpMethod.GET,
//                                bookDto,
//                                Category.class,
//                                this::toError);
//                            categoryDAO.save(result);
//            response = categoryDAO.findById(bookDto.getCategoryId()).orElseThrow(() ->
//                new ApiRequestException(
//                        String.format("Not found Category with id = [%d]", bookDto.getCategoryId()))
//        );
//        Product book = new Product();
//        book.convertFromAddBook(bookDto);
//        book.setCate(response);
//        return bookDAO.save(book);
//        }
//        catch (ApiRequestException ex){
//            throw new ApiRequestException("not found");
//        }
//    }
//
//    protected String toError(Object response) {
//        if (response instanceof StatusLine) {
//            if (((StatusLine) response).getStatusCode() != 200)
//                return ((StatusLine) response).getReasonPhrase();
//            return null;
//        }
//        throw new ApiRequestException("Unknown error");
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return null;
//    }
//
//    @Override
//    public Product findById(Integer bookId) {
//        return null;
//    }
//
//    @Override
//    public void deleteById(Integer bookId) {
//
//    }
//
//    @Override
//    public Product updateBook(UpdateBook updateBook) {
//        return null;
//    }
//
//    @Override
//    public List<Product> findByCateCategoryId(Integer categoryId) {
//        return null;
//    }
//}
