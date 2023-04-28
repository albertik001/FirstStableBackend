package com.example.testbackendone.controller;

import com.example.testbackendone.error_response.CustomErrorResponse;
import com.example.testbackendone.model.Note;
import com.example.testbackendone.repository.NoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable Long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return ResponseEntity.ok().body(optionalNote.get());
        } else {
            CustomErrorResponse errorResponse = new CustomErrorResponse("Заметка с указанным ID не найдена");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        return noteRepository.findById(id).map(existingNote -> {
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
            return ResponseEntity.ok().body(noteRepository.save(existingNote));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        return noteRepository.findById(id).map(note -> {
            noteRepository.delete(note);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Note> patchNote(@PathVariable Long id, @RequestBody Note note) {
        return noteRepository.findById(id).map(existingNote -> {
            if (note.getTitle() != null) {
                existingNote.setTitle(note.getTitle());
            }
            if (note.getContent() != null) {
                existingNote.setContent(note.getContent());
            }
            return ResponseEntity.ok().body(noteRepository.save(existingNote));
        }).orElse(ResponseEntity.notFound().build());
    }
}

