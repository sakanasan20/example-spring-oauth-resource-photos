package tw.niq.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.niq.example.model.PhotoResponseModel;

@RestController
@RequestMapping("/photos")
public class PhotoController {

	@GetMapping
	public List<PhotoResponseModel> getPhotos() {
		
		PhotoResponseModel photo1 = new PhotoResponseModel();
		
		photo1.setAlbumId("1");
		photo1.setPhotoId("1");
		photo1.setUserId("1");
		photo1.setPhotoTitle("Phtot 1 Title");
		photo1.setPhotoDescription("Phtot 1 Description");
		photo1.setPhotoUrl("Phtot 1 URL");
		
		PhotoResponseModel photo2 = new PhotoResponseModel();
		
		photo2.setAlbumId("1");
		photo2.setPhotoId("2");
		photo2.setUserId("1");
		photo2.setPhotoTitle("Phtot 2 Title");
		photo2.setPhotoDescription("Phtot 2 Description");
		photo2.setPhotoUrl("Phtot 2 URL");
		
		return Arrays.asList(photo1, photo2);
	}
	
}
