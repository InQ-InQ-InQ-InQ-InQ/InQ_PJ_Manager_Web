// new Swiper(선택자, 옵션)
new Swiper('.project .swiper', {
  slidesPerView: 4, // 한번에 보여줄 슬라이드 개수
  spaceBetween: 10, // 슬라이드 사이 여백
  centeredSlides: true, // 1번 슬라이드가 가운데 보이기
  loop: true,
  autoplay: {
    delay: 5000 // 5초 , 밀리세컨 단위
  },
  navigation: {
    prevEl: '.project .swiper-prev',
    nextEl: '.project .swiper-next'
  }
});