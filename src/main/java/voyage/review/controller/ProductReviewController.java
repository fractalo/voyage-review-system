package voyage.review.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import voyage.review.dto.ProductReviewParam;
import voyage.review.service.ProductReviewService;

@RestController
@RequiredArgsConstructor
public class ProductReviewController {
    private final ProductReviewService productReviewService;

    @PostMapping("/products/{productId}/reviews")
    public void addReview(@PathVariable Long productId,
                          @Valid @RequestPart("review") ProductReviewParam reviewParam,
                          @RequestPart(value = "image", required = false) MultipartFile imageFile) {
        productReviewService.addReview(productId, reviewParam);
    }


}
