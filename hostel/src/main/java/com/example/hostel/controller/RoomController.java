package com.example.hostel.controller;

import com.example.hostel.model.Room;
import com.example.hostel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allows requests from all origins (useful for frontend later)
public class RoomController {

    @Autowired
    private RoomService roomService;

    // GET /rooms
    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // GET /room/{id}
    @GetMapping("/room/{id}")
    public Optional<Room> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    // GET /rooms/type/{type}
    @GetMapping("/rooms/type/{type}")
    public List<Room> getRoomsByType(@PathVariable String type) {
        return roomService.getRoomsByType(type);
    }

    // POST /room
    @PostMapping("/room")
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    // PUT /room/{id}
    @PutMapping("/room/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }

    // DELETE /room/{id}
    @DeleteMapping("/room/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}
