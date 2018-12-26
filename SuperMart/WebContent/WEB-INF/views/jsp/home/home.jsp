<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
	<div class="span12">
		<div class="row">
			<div class="span12">
				<h4 class="title">
					<span class="pull-left"><span class="text"><span
							class="line">Feature <strong>Products</strong></span></span></span> <span
						class="pull-right"> <a class="left button"
						href="#myCarousel" data-slide="prev"></a><a class="right button"
						href="#myCarousel" data-slide="next"></a>
					</span>
				</h4>
				<div id="myCarousel" class="myCarousel carousel slide"></div>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="span12">
				<h4 class="title">
					<span class="pull-left"><span class="text"><span
							class="line">Latest <strong>Products</strong></span></span></span> <span
						class="pull-right"> <a class="left button"
						href="#myCarousel-2" data-slide="prev"></a><a class="right button"
						href="#myCarousel-2" data-slide="next"></a>
					</span>
				</h4>
			</div>
		</div>
		<div class="row feature_box">
			<div class="span4">
				<div class="service">
					<div class="responsive">
						<img
							src="${pageContext.request.contextPath}/resources/themes/images/feature_img_2.png"
							alt="" />
						<h4>
							MODERN <strong>DESIGN</strong>
						</h4>
						<p>Lorem Ipsum is simply dummy text of the printing and
							printing industry unknown printer.</p>
					</div>
				</div>
			</div>
			<div class="span4">
				<div class="service">
					<div class="customize">
						<img
							src="${pageContext.request.contextPath}/resources/themes/images/feature_img_1.png"
							alt="" />
						<h4>
							FREE <strong>SHIPPING</strong>
						</h4>
						<p>Lorem Ipsum is simply dummy text of the printing and
							printing industry unknown printer.</p>
					</div>
				</div>
			</div>
			<div class="span4">
				<div class="service">
					<div class="support">
						<img
							src="${pageContext.request.contextPath}/resources/themes/images/feature_img_3.png"
							alt="" />
						<h4>
							24/7 LIVE <strong>SUPPORT</strong>
						</h4>
						<p>Lorem Ipsum is simply dummy text of the printing and
							printing industry unknown printer.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
		var url = '${pageContext.request.contextPath}/home/viewNewMerchansedise?first='+0+'&max='+7; 
		$('#myCarousel').load(url);
	})
</script>