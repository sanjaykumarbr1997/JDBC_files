package com.xworkz.facebook_app.dao;

import com.xworkz.facebook_app.dto.FacebookDTO;

import java.util.List;

public interface FacebookDAO {

    public void createFaceBook(FacebookDTO bookDTO);
    public List<FacebookDTO> getAllFaceBookDetails();
}
