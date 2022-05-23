$('.underline').each(function(index){
  $(this).attr('underline-index', index);
}).click(function(){
  /*클릭된 <div>의 menu-index 값을 index 변수에 할당한다.*/
  var index = $(this).attr('underline-index');
  /*클릭한 <div>에  click-line 클래스 추가*/
  $('.underline[underline-index=' + index + ']').addClass('click-line'); 
    /*그 외 <div>는  click-line 클래스 삭제*/
  $('.underline[underline-index!=' + index + ']').removeClass('click-line');
});