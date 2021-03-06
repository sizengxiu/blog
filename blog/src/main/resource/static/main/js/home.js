$(function() {
    initList();
});
function initList(){
    var type=getQueryVariable("type");
    $.ajax({
        type:"post",
        url: "/blog/blogMenu/getBlogMenuListByType",
        data:{"typeCode":type},
        success: function (result) {
            if(result.success){
                var menuList="";
                $.each(result.data,function(i,item){
                    menuList+="<li class='nav-item'>";
                    menuList +="<div id='list_item'>"+i+"、<a href='javascript:;' onclick='openBlog(this);' url='"+item.url+"'><span>"+item.name+"</span></a>"+"</div>";
                    menuList +="<span>阅读次数："+item.clickTimes+"</span>";
                    menuList +="<span>更新时间："+item.updateTime+"</span>";
                    menuList +="</li>";
                });
                $("#blog_list_ul").append(menuList);
            }
        }
    });
}