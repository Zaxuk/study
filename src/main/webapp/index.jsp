<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<script src="http://ku-res.17wo.cn/wap-video-storm/scripts/jquery-1.8.2.min.js" type="text/javascript"></script>
<html>
<head>
    <title>Study</title>
    <style>
        body {
            text-align: center
        }

        div {
            margin: 0 auto;
        }

        input {
            width: 100px;
        }
    </style>
</head>
<body>
<div>
    <ul>
        编号：<input id="id" name="id" type="text"/>
    </ul>
    <ul>
        名字：<input id="name" name="name" type="text"/>
    </ul>
    <ul>
        <input type="button" value="提交"/>
    </ul>
    <ul id="list">
        ${str}
    </ul>
</div>
</body>
<script>

    $("input[type=button]").on("click", function () {
        var url = "Index!add";
        $.ajax({
            url: url,
            data: {
                id: $("#id").val(),
                name: $("#name").val()
            },
            dataType: "json",
            success: function (res) {
                if (res.success) {
                    $("#list").html(res.data.list);
                } else {
                    $("#list").html(res.message);
                }
            }
        })
    });

</script>
</html>
