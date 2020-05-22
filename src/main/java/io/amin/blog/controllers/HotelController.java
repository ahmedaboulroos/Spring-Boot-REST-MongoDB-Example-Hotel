package io.amin.blog.controllers;

import io.amin.blog.models.Hotel;
import io.amin.blog.repositories.HotelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getAllHotelsWithPriceLessThan(@PathVariable int maxPrice) {
        return hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    @GetMapping("/{hotelId}")
    public Hotel getHotelById(@PathVariable String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow();
    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @PutMapping("/{hotelId}")
    public Hotel updateHotel(@PathVariable String hotelId, @RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @DeleteMapping("/{hotelId}")
    public void deleteHotel(@PathVariable String hotelId) {
        hotelRepository.deleteById(hotelId);
    }

}
