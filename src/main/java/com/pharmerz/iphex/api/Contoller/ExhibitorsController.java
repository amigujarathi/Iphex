//package com.pharmerz.iphex.api.Contoller;
//
//import com.pharmerz.iphex.api.server.domain.model.Exhibitors;
//import com.pharmerz.iphex.api.server.domain.repository.IExhibitorsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Collection;
//
///**
// * Created by i5 on 4/15/2017.
// */
//
//@RestController
//@RequestMapping("/api/v1/")
//public class ExhibitorsController {
//
//    @Autowired
//    ExhibitorsRepository exhibitorsRepository;
//
//
//
//    @GetMapping(value = "/exhibitorsall",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Collection<Exhibitors>> getExhibitorss(){
//        Collection<Exhibitors> exhibitorss=exhibitorsRepository.findAll();
//        System.out.println("*************************************************************");
//        System.out.println("from controller findall"+exhibitorss.iterator());
//
//        return new ResponseEntity<Collection<Exhibitors>>(exhibitorss, HttpStatus.OK);
//    }

//    @GetMapping(value = "/exhibitors",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Page<Exhibitors>> getExhibitorss(Pageable pageable){
//        Page<Exhibitors> exhibitorss=exhibitorsRepository.findAll(pageable);
//        Page<Exhibitors> paging =exhibitorsRepository.findAll(pageable);
//
//
//        return new ResponseEntity<Page<Exhibitors>>(paging, HttpStatus.OK);
//    }
//}
