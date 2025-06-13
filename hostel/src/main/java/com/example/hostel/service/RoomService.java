package com.example.hostel.service;

import com.example.hostel.model.Room;
import com.example.hostel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    // Get all rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Get room by ID
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    // Get rooms by type
    public List<Room> getRoomsByType(String type) {
        return roomRepository.findByRoomType(type);
    }

    // Create new room
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    // Update room
    public Room updateRoom(Long id, Room updatedRoom) {
        Optional<Room> existing = roomRepository.findById(id);
        if (existing.isPresent()) {
            Room room = existing.get();
            room.setStudentId(updatedRoom.getStudentId());
            room.setRoomType(updatedRoom.getRoomType());
            room.setDuration(updatedRoom.getDuration());
            return roomRepository.save(room);
        } else {
            return null;
        }
    }

    // Delete room
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
