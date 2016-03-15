package com.backoffice.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.ws.rs.BadRequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.backoffice.dao.models.ImageModel;
import com.backoffice.facade.ImageFacade;

@Controller
@RequestMapping("/image")
public class ImageUploadController {

	private static final Logger LOG = LoggerFactory.getLogger(ImageUploadController.class);

	@Value("${imageRootFolder}")
	private String root = "";

	@Autowired
	private ImageFacade imageFacade;

	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST)
	public void handleFileUpload(@RequestParam("name") final String name,
			@RequestParam("file") final MultipartFile file) {
		LOG.debug("handleFileUpload is called");

		if (!file.isEmpty()) {
			try (BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(root + "/" + name)))) {
				FileCopyUtils.copy(file.getInputStream(), stream);
				stream.close();

			} catch (final Exception e) {
				throw new BadRequestException("failed to upload file");
			}
		}
	}

	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public Iterable<ImageModel> getAllImages() {
		LOG.debug("getAllImages is called");
		return imageFacade.getAll();
	}

	public void setRoot(final String root) {
		this.root = root;
	}

}
