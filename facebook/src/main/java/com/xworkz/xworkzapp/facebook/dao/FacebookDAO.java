package com.xworkz.xworkzapp.facebook.dao;


import java.util.List;

import com.xworkz.xworkzapp.facebook.dto.FacebookDTO;

public interface FacebookDAO {

    public void createFaceBook(FacebookDTO bookDTO);
    public List<FacebookDTO> getAllFaceBookDetails();
    
    
}
