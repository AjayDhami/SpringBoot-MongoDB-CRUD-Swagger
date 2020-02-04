package com.spring.mongo.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "Book")
@ApiModel(description = "Details about Book")
public class Book {

	@Id
	@ApiModelProperty(notes = "Unique Id of the book")
	private int id;

	@ApiModelProperty(notes = "Name of the Book")
	private String bookName;

	@ApiModelProperty(notes = "Author of the Book")
	private String authorName;
}
