package io.amin.blog.configs;

import io.amin.blog.models.Address;
import io.amin.blog.models.Hotel;
import io.amin.blog.models.Review;
import io.amin.blog.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MongoSeeder implements CommandLineRunner {

    private final HotelRepository hotelRepository;

    public MongoSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Hotel hotel1 = new Hotel();
        hotel1.setName("first hotel");
        hotel1.setPricePerNight(1000);
        hotel1.setAddress(new Address("cairo", "egypt"));
        hotel1.setReviews(Arrays.asList(
                new Review("amin", 1, true),
                new Review("amr", 4, true),
                new Review("nora", 3, false),
                new Review("iman", 2, false)
        ));

        Hotel hotel2 = new Hotel();
        hotel2.setName("second hotel");
        hotel2.setPricePerNight(2000);
        hotel2.setAddress(new Address("october", "egypt"));
        hotel2.setReviews(Arrays.asList(
                new Review("amin", 1, true),
                new Review("amr", 1, true),
                new Review("nora", 2, false),
                new Review("iman", 1, false)
        ));

        Hotel hotel3 = new Hotel();
        hotel3.setName("third hotel");
        hotel3.setPricePerNight(3000);
        hotel3.setAddress(new Address("zamalek", "egypt"));
        hotel3.setReviews(Arrays.asList(
                new Review("amin", 4, true),
                new Review("amr", 3, true),
                new Review("nora", 5, false),
                new Review("iman", 3, false)
        ));

        hotelRepository.deleteAll();

        List<Hotel> hotels = Arrays.asList(hotel1, hotel2, hotel3);

        hotelRepository.saveAll(hotels);

    }

}
