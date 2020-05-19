
$(function(){
    $.ajax({
        url:"/blog/blogMenu/getBlogMenuList",
        success:function(data){
            if(data.success){
                var menuList="";
                $.each(data.data,function(i,item){
                    menuList+="<li class='nav-item'>";
                    menuList += "<a href='javascript:;'><i  class='my-icon nav-icon icon_3'></i><span>"+item.name+"</span><i class='my-icon nav-more'></i></a>";
                    menuList +="<ul>";

                    $.each(item.childList,function(j,childItem){
                        // menuList +="<li><a href='javascript:;' onclick='openBlog(this,"+childItem+");' url='"+childItem.url+"'><span>"+childItem.name+"</span></a></li>";
                        menuList +="<li><a href='javascript:;' onclick='openBlog1(\""+childItem.id+"\",\""+childItem.url+"\")'><span>"+childItem.name+"</span></a></li>";
                    });
                    menuList +="</ul>";
                    menuList +="</li>";
                });
                $("#blog_menu_ul").append(menuList);
            }
            bindMenuClickEvent();
        }
    });

    /**
     * 绑定菜单点击事件
     */
  function bindMenuClickEvent(){
      // nav收缩展开
      $('.nav-item>a').on('click',function(){
          if (!$('.nav').hasClass('nav-mini')) {
              if ($(this).next().css('display') == "none") {
                  //展开未展开
                  $('.nav-item').children('ul').slideUp(300);
                  $(this).next('ul').slideDown(300);
                  $(this).parent('li').addClass('nav-show').siblings('li').removeClass('nav-show');
              }else{
                  //收缩已展开
                  $(this).next('ul').slideUp(300);
                  $('.nav-item.nav-show').removeClass('nav-show');
              }
          }
      });
        //nav-mini切换
        $('#mini').on('click',function(){
            if (!$('.nav').hasClass('nav-mini')) {
                $('.nav-item.nav-show').removeClass('nav-show');
                $('.nav-item').children('ul').removeAttr('style');
                $('.nav').addClass('nav-mini');
            }else{
                $('.nav').removeClass('nav-mini');
            }
        });

    }


});
/**
 * iframe自适应高度，height为手动设置的最小高度
 */
function initIframeHeight(height){
    alert(3);
    var userAgent = navigator.userAgent;
    var iframe = parent.document.getElementById("contentIframe");
    var subdoc = iframe.contentDocument || iframe.contentWindow.document;
    var subbody = subdoc.body;
    var realHeight;
    //谷歌浏览器特殊处理
    if(userAgent.indexOf("Chrome") > -1){
        realHeight = subdoc.documentElement.scrollHeight;
    }
    else{
        realHeight = subbody.scrollHeight;
    }
    if(realHeight < height){
        $(iframe).height(height);
    }
    else{
        $(iframe).height(realHeight);
    }
}
//日志点击事件
function openBlog(data){
    console.info(data);
    console.info(this);
    $("#content").attr("src", "/blog"+url.getAttribute("url"));
    // var type="01";
    // $("#content").attr("src", "/blog/main/html/blog_list.html?type="+type);
}
//日志点击事件
function openBlog1(id,url){
    console.info(id+url);
    $("#content").attr("src", "/blog"+url);
    $.ajax({
        type: "post",
        url: "/blog/blogMenu/clickBlog",
        data: {"blogId": id},
        success: function (result) {

        }
    });
}


