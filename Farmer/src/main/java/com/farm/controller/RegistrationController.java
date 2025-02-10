package com.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farm.entity.User;
import com.farm.entity.WasteCastorCrop;
import com.farm.entity.WasteCornBot;
import com.farm.entity.WasteCottonPlantLeftOuts;
import com.farm.entity.WasteRiceHusk;
import com.farm.entity.WasteTobaccoCrop;
import com.farm.entity.WasteWheatHusk;
import com.farm.register.UserModel;
import com.farm.repository.WasteCastorCropRepo;
import com.farm.repository.WasteCornBotRepo;
import com.farm.repository.WasteCottonPlantLeftOutsRepo;
import com.farm.repository.WasteRiceHuskRepo;
import com.farm.repository.WasteTobaccoCropRepo;
import com.farm.repository.WasteWheatHuskRepo;
import com.farm.service.UserService;

@RestController
@CrossOrigin
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private WasteRiceHuskRepo riceHuskRepo;

    @Autowired
    private WasteTobaccoCropRepo tobaccoCropRepo;

    @Autowired
    private WasteWheatHuskRepo wheatHuskRepo;

    @Autowired
    private WasteCastorCropRepo castorCropRepo;

    @Autowired
    private WasteCornBotRepo cornBotRepo;

    @Autowired
    private WasteCottonPlantLeftOutsRepo cottonPlantLeftOutsRepo;
    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        User user = userService.registerUser(userModel);
        long id = user.getId();

        WasteCastorCrop w1 = new WasteCastorCrop(id, 0, 0);
        castorCropRepo.save(w1);

        WasteCornBot w2 = new WasteCornBot(id, 0, 0);
        cornBotRepo.save(w2);

        WasteWheatHusk w3 = new WasteWheatHusk(id, 0, 0);
        wheatHuskRepo.save(w3);

        WasteTobaccoCrop w4 = new WasteTobaccoCrop(id, 0, 0);
        tobaccoCropRepo.save(w4);

        WasteCottonPlantLeftOuts w5 = new WasteCottonPlantLeftOuts(id, 0, 0);
        cottonPlantLeftOutsRepo.save(w5);

        WasteRiceHusk w6 = new WasteRiceHusk(id, 0, 0);
        riceHuskRepo.save(w6);
        return "Success";
    }

    
   
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserModel userModel) {
        try {
            User user = userService.loginUser(userModel.getEmail(), userModel.getPassword());
            return ResponseEntity.ok(user); // Return user data (consider removing sensitive information)
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


}