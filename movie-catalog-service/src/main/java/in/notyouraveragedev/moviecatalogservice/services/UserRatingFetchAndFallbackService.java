package in.notyouraveragedev.moviecatalogservice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import in.notyouraveragedev.moviecatalogservice.models.Rating;
import in.notyouraveragedev.moviecatalogservice.models.UserRating;

@Service
public class UserRatingFetchAndFallbackService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "defaultUserRatingFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000") })
	public UserRating getUserRatingInformation(String userId) {
		System.out.println("[**@**] inside getUserRatingInformation");
		return restTemplate.getForObject("http://rating-data-service/rating/user/" + userId, UserRating.class);
	}

	@SuppressWarnings({ "serial", "unused" })
	private UserRating defaultUserRatingFallBack(String userId) {
		System.out.println("[**@**] inside defaultUserRatingFallBack");
		return new UserRating(userId, new ArrayList<Rating>() {
			{
				add(new Rating("0", 0));
			}
		});
	}
}
