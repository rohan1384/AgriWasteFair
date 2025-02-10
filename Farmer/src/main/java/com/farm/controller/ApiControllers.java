package com.farm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farm.entity.User;
import com.farm.entity.WasteCastorCrop;
import com.farm.entity.WasteCornBot;
import com.farm.entity.WasteCottonPlantLeftOuts;
import com.farm.entity.WasteRiceHusk;
import com.farm.entity.WasteTobaccoCrop;
import com.farm.entity.WasteWheatHusk;
import com.farm.exception.ResourceNotFoundException;
import com.farm.repository.UserRepository;
import com.farm.repository.WasteCastorCropRepo;
import com.farm.repository.WasteCornBotRepo;
import com.farm.repository.WasteCottonPlantLeftOutsRepo;
import com.farm.repository.WasteRiceHuskRepo;
import com.farm.repository.WasteTobaccoCropRepo;
import com.farm.repository.WasteWheatHuskRepo;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class ApiControllers {

//    REPO'S
    @Autowired
    private UserRepository userRepo;

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

//    WASTES OPERATIONS

//    RICE HUSK
    @GetMapping(value = "/farmers/{id}/ricehusk")
    public ResponseEntity<WasteRiceHusk> getRiceHuskById(@PathVariable Long id) {
        User employee = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not exist with id :" + id));
        WasteRiceHusk waste = riceHuskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste has not been sold"));
        return ResponseEntity.ok(waste);
    }



    @PutMapping("/farmers/{id}/ricehusk")
    public ResponseEntity<WasteRiceHusk> updateRiceHusk(@PathVariable Long id, @RequestBody WasteRiceHusk waste){
        WasteRiceHusk wastee = riceHuskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("waste not exist with id :" + id));

        wastee.setQuantity(waste.getQuantity() + wastee.getQuantity());
        wastee.setRevenue(waste.getRevenue() + wastee.getRevenue());

        WasteRiceHusk updatedWaste = riceHuskRepo.save(wastee);
        return ResponseEntity.ok(updatedWaste);
    }

//    TOBACCO CROP

    @GetMapping(value = "/farmers/{id}/tobaccocrop")
    public ResponseEntity<WasteTobaccoCrop> getTobaccoCropById(@PathVariable Long id) {
        User employee = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not exist with id :" + id));
        WasteTobaccoCrop waste = tobaccoCropRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste has not been sold"));
        return ResponseEntity.ok(waste);
    }



    @PutMapping("/farmers/{id}/tobaccocrop")
    public ResponseEntity<WasteTobaccoCrop> updateTobaccoCrop(@PathVariable Long id, @RequestBody WasteTobaccoCrop waste){
        WasteTobaccoCrop wastee = tobaccoCropRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("waste not exist with id :" + id));

        wastee.setQuantity(waste.getQuantity() + wastee.getQuantity());
        wastee.setRevenue(waste.getRevenue() + wastee.getRevenue());

        WasteTobaccoCrop updatedWaste = tobaccoCropRepo.save(wastee);
        return ResponseEntity.ok(updatedWaste);
    }

//    WHEAT HUSK

    @GetMapping(value = "/farmers/{id}/wheathusk")
    public ResponseEntity<WasteWheatHusk> getWheatHuskById(@PathVariable Long id) {
        User employee = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not exist with id :" + id));
        WasteWheatHusk waste = wheatHuskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste has not been sold"));
        return ResponseEntity.ok(waste);
    }



    @PutMapping("/farmers/{id}/wheathusk")
    public ResponseEntity<WasteWheatHusk> updateWheatHusk(@PathVariable Long id, @RequestBody WasteWheatHusk waste){
        WasteWheatHusk wastee = wheatHuskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("waste not exist with id :" + id));

        wastee.setQuantity(waste.getQuantity() + wastee.getQuantity());
        wastee.setRevenue(waste.getRevenue() + wastee.getRevenue());

        WasteWheatHusk updatedWaste = wheatHuskRepo.save(wastee);
        return ResponseEntity.ok(updatedWaste);
    }

//    CASTOR CROP

    @GetMapping(value = "/farmers/{id}/castorcrop")
    public ResponseEntity<WasteCastorCrop> getCastorCropById(@PathVariable Long id) {
        User employee = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not exist with id :" + id));
        WasteCastorCrop waste = castorCropRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste has not been sold"));
        return ResponseEntity.ok(waste);
    }



    @PutMapping("/farmers/{id}/castorcrop")
    public ResponseEntity<WasteCastorCrop> updateCastorCrop(@PathVariable Long id, @RequestBody WasteCastorCrop waste){
        WasteCastorCrop wastee = castorCropRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("waste not exist with id :" + id));

        wastee.setQuantity(waste.getQuantity() + wastee.getQuantity());
        wastee.setRevenue(waste.getRevenue() + wastee.getRevenue());

        WasteCastorCrop updatedWaste = castorCropRepo.save(wastee);
        return ResponseEntity.ok(updatedWaste);
    }

//    CORN BOT

    @GetMapping(value = "/farmers/{id}/cornbot")
    public ResponseEntity<WasteCornBot> getCornBotById(@PathVariable Long id) {
        User employee = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not exist with id :" + id));
        WasteCornBot waste = cornBotRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste has not been sold"));
        return ResponseEntity.ok(waste);
    }



    @PutMapping("/farmers/{id}/cornbot")
    public ResponseEntity<WasteCornBot> updateCornBot(@PathVariable Long id, @RequestBody WasteCornBot waste){
        WasteCornBot wastee = cornBotRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("waste not exist with id :" + id));

        wastee.setQuantity(waste.getQuantity() + wastee.getQuantity());
        wastee.setRevenue(waste.getRevenue() + wastee.getRevenue());

        WasteCornBot updatedWaste = cornBotRepo.save(wastee);
        return ResponseEntity.ok(updatedWaste);
    }

//    COTTON PLANT

    @GetMapping(value = "/farmers/{id}/cottonplants")
    public ResponseEntity<WasteCottonPlantLeftOuts> getCottonPlantById(@PathVariable Long id) {
        User employee = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not exist with id :" + id));
        WasteCottonPlantLeftOuts waste = cottonPlantLeftOutsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste has not been sold"));
        return ResponseEntity.ok(waste);
    }



    @PutMapping("/farmers/{id}/cottonplants")
    public ResponseEntity<WasteCottonPlantLeftOuts> updateCottonPlant(@PathVariable Long id, @RequestBody WasteCottonPlantLeftOuts waste){
        WasteCottonPlantLeftOuts wastee = cottonPlantLeftOutsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("waste not exist with id :" + id));

        wastee.setQuantity(waste.getQuantity() + wastee.getQuantity());
        wastee.setRevenue(waste.getRevenue() + wastee.getRevenue());

        WasteCottonPlantLeftOuts updatedWaste = cottonPlantLeftOutsRepo.save(wastee);
        return ResponseEntity.ok(updatedWaste);
    }

//    GET TOTAL REVENUE

    @GetMapping(value = "/farmers/{id}/totalrevenue")
    public ResponseEntity<Double> getTotalRevenue(@PathVariable Long id) {
        User employee = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not exist with id :" + id));

        WasteRiceHusk w1 = riceHuskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        WasteTobaccoCrop w2 = tobaccoCropRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        WasteWheatHusk w3 = wheatHuskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        WasteCornBot w4 = cornBotRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        WasteCastorCrop w5 = castorCropRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        WasteCottonPlantLeftOuts w6 = cottonPlantLeftOutsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        double totalRevenue = 0;
        totalRevenue += w1.getRevenue() + w2.getRevenue() + w3.getRevenue() + w4.getRevenue() + w5.getRevenue() + w6.getRevenue();

        return ResponseEntity.ok(totalRevenue);
    }

//    GET LIST OF QUANTITIES
    @GetMapping(value = "/farmers/{id}/wastes")
    public ResponseEntity<HashMap<String, Integer>> getEachQuantity(@PathVariable Long id) {
        User employee = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not exist with id :" + id));

        WasteRiceHusk w1 = riceHuskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        WasteTobaccoCrop w2 = tobaccoCropRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        WasteWheatHusk w3 = wheatHuskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        WasteCornBot w4 = cornBotRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        WasteCastorCrop w5 = castorCropRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        WasteCottonPlantLeftOuts w6 = cottonPlantLeftOutsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste does not exist"));

        HashMap<String, Integer> mp = new HashMap<>();

        mp.put("castorCrop", w5.getQuantity());
        mp.put("cornBot", w4.getQuantity());
        mp.put("cottonPlants", w6.getQuantity());
        mp.put("riceHusk", w1.getQuantity());
        mp.put("tobaccoCrop", w2.getQuantity());
        mp.put("wheatHustk", w3.getQuantity());

        return ResponseEntity.ok(mp);
    }
}