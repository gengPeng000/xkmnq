window.onload=function(){
    if(window.location.pathname.indexOf('tanchuang')>-1){
    }else{
        if(window.location.search==''){
            loadAnimation();
        }
    }
}
$(function () {
    // document.getElementById("loadA").className = "load-animation";
    /* 添加亲密等级 */
    LV()
    /* 亲密的等级 */
    qmd()
    // 角色选择图片的加载
    imgJZ();
    /* 亲密度选择事件触发 */
    QMDChange()
    /* 等级选择事件触发 */
    lvChange()
})
function loadAnimation(){
    document.getElementById("loadA").className = "load-animation";
    setTimeout(()=>{
        document.getElementById("loadA").className = "hide-animation";
    },1000)
}
/* 点击号位跳转到角色选择页面 */
function choose(id) {
    sessionStorage.setItem('id', id);
    window.location.href = 'tanchuang.html';
}

//重置
function resert(){
    window.location.href ="index.html?type=resert";
}

/* 点击弹框的觉色获取角色的名称 */
function jsCLick(name) {
    var id = sessionStorage.getItem('id'); // 获取前个页面点击的号位
    var array = JSON.parse(sessionStorage.getItem('array'));
    var array1 = JSON.parse(JSON.stringify(array))
    if(array.length>0){
        for(var i=0;i<array.length;i++){

            if(array[i] && array[i].name == name){
                alert("侠客"+name+"已选，请选择其他侠客")
                // window.location.href = 'index.html?name=' + name; // 跳转到index页面
                return false
            }else{
                var obj = { id:id, name:name }; // 组合当前的号位和角色
                switch (id) {
                    case 'one':
                        array1[0] = obj
                        break;
                    case 'two':
                        array1[1] = obj
                        break;
                    case 'three':
                        array1[2] = obj
                        break;
                    case 'four':
                        array1[3] = obj
                        break;
                    case 'five':
                        array1[4] = obj
                        break;
                    case 'six':
                        array1[5] = obj
                        break;
                }


            }
        }
        sessionStorage.setItem('array', JSON.stringify(array1));
        window.location.href = 'index.html?name=' + name; // 跳转到index页面
    }else{
        var obj = { id:id, name:name }; // 组合当前的号位和角色
        switch (id) {
            case 'one':
                array1[0] = obj
                break;
            case 'two':
                array1[1] = obj
                break;
            case 'three':
                array1[2] = obj
                break;
            case 'four':
                array1[3] = obj
                break;
            case 'five':
                array1[4] = obj
                break;
            case 'six':
                array1[5] = obj
                break;
        }

        sessionStorage.setItem('array', JSON.stringify(array1));
        window.location.href = 'index.html?name=' + name; // 跳转到index页面
    }



}

/* 角色选择图片的加载 */
function imgJZ() {
    var url = window.location.href; // 获取当前路径
    if (url.indexOf('index') > -1 && url.indexOf('?') > -1) { // 判断当前是否带有角色名称
        // 带有角色名称后可以对array数组进行循环
        var array = JSON.parse(sessionStorage.getItem('array'));
        for (var i in array) {
            if (array[i]) {
                var item = array[i];
                var html = '<img  src=../img/' + item.name + '.bmp width="63px" height="63px" border=0>';
                $('#' + item.id).html(html);
                var lv = $('#' + item.id + 'LV').val();
                var qmd = $('#' + item.id + 'QMD').val();
                item.number = parseInt(wz(item.id));
                item.level = parseInt(lv);
                item.qinmudu = parseInt(qmd);
                $('#' + item.id + 'LV').removeAttr("disabled");
                $('#' + item.id + 'QMD').removeAttr("disabled");
            }
        }
        sx(array); // 调用请求
    } else if (url.indexOf('?') < 0 && url.indexOf('index') > -1) {
        sessionStorage.setItem('array', '[]'); // 初始设置角色与位置的对应数组
        sessionStorage.setItem('id', '');
    }
}

/* 添加角色等级 */
function LV() {
    var html = ''
    for (var index = 1; index <= 150; index++) {
        html += '<option value="' + index + '">lv' + index + '</option>'
    }
    $('#oneLV').html(html)
    $('#twoLV').html(html)
    $('#threeLV').html(html)
    $('#fourLV').html(html)
    $('#fiveLV').html(html)
    $('#sixLV').html(html)
}
/* 亲密的等级 */
function qmd() {
    var html = ''
    for (var index = 0; index <=39; index++) {
        html += '<option value="' + index + '">QM' + index + '</option>'
    }
    $('#oneQMD').html(html)
    $('#twoQMD').html(html)
    $('#threeQMD').html(html)
    $('#fourQMD').html(html)
    $('#fiveQMD').html(html)
    $('#sixQMD').html(html)
}


/* 亲密度选择事件触发 */
function QMDChange() {
    $('#oneQMD').bind('change', function () {
        var lv = $(this).val(); // 获取当前的亲密度
        lvAjax('oneQMD', lv); // ajax 请求  无法请求到先用模拟数据
    })
    $('#twoQMD').bind('change', function () {
        var lv = $(this).val(); // 获取当前的亲密度
        lvAjax('twoQMD', lv); // ajax 请求  无法请求到先用模拟数据
    })
    $('#threeQMD').bind('change', function () {
        var lv = $(this).val(); // 获取当前的亲密度
        lvAjax('threeQMD', lv); // ajax 请求  无法请求到先用模拟数据
    })
    $('#fourQMD').bind('change', function () {
        var lv = $(this).val(); // 获取当前的亲密度
        lvAjax('fourQMD', lv); // ajax 请求  无法请求到先用模拟数据
    })
    $('#fiveQMD').bind('change', function () {
        var lv = $(this).val(); // 获取当前的亲密度
        lvAjax('fiveQMD', lv); // ajax 请求  无法请求到先用模拟数据
    })
    $('#sixQMD').bind('change', function () {
        var lv = $(this).val(); // 获取当前的亲密度
        lvAjax('sixQMD', lv); // ajax 请求  无法请求到先用模拟数据
    })
}
/* 等级选择事件触发 */
function lvChange() {
    $('#oneLV').bind('change', function () {
        var lv = $(this).val(); // 获取当前的等级
        var array = JSON.parse(sessionStorage.getItem('allData'));// 选择图片是保存的数据
        array[0].level = parseInt(lv);
        sx(array)
    })
    $('#twoLV').bind('change', function () {
        var lv = $(this).val(); // 获取当前的等级
        var array = JSON.parse(sessionStorage.getItem('allData'));// 选择图片是保存的数据
        array[1].level = parseInt(lv);
        sx(array)
    })
    $('#threeLV').bind('change', function () {
        var lv = $(this).val(); // 获取当前的等级
        var array = JSON.parse(sessionStorage.getItem('allData'));// 选择图片是保存的数据
        array[2].level = parseInt(lv);
        sx(array)
    })
    $('#fourLV').bind('change', function () {
        var lv = $(this).val(); // 获取当前的等级
        var array = JSON.parse(sessionStorage.getItem('allData'));// 选择图片是保存的数据
        array[3].level = parseInt(lv);
        sx(array)
    })
    $('#fiveLV').bind('change', function () {
        var lv = $(this).val(); // 获取当前的等级
        var array = JSON.parse(sessionStorage.getItem('allData'));// 选择图片是保存的数据
        array[4].level = parseInt(lv);
        sx(array)
    })
    $('#sixLV').bind('change', function () {
        var lv = $(this).val(); // 获取当前的等级
        var array = JSON.parse(sessionStorage.getItem('allData'));// 选择图片是保存的数据
        array[5].level = parseInt(lv);
        sx(array)
    })
}
/* 调用亲密度等级对应的ajax */
function lvAjax(id, lv) {

    $.ajax({
        //请求方式
        type: 'GET',
        //发送请求的地址
        url: '/xajh/xkmnq/findbiaoshi',
        //服务器返回的数据类型
        dataType: 'json',
        //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
        data: { level: lv },
        success: function (data) {
            //请求成功函数内容
            if (data.code == 1001) {
                $('#' + id).parent().next().html(data.data);
                // 请求成功后重新调用属性数据
                var array = JSON.parse(sessionStorage.getItem('allData'));// 选择图片是保存的数据
                if (id == 'oneQMD') {
                    array[0].qinmidu = parseInt(lv);
                }
                else if (id == 'twoQMD') {
                    array[1].qinmidu = parseInt(lv);
                }
                else if (id == 'threeQMD') {
                    array[2].qinmidu = parseInt(lv);
                }
                else if (id == 'fourQMD') {
                    array[3].qinmidu = parseInt(lv);
                }
                else if (id == 'fiveQMD') {
                    array[4].qinmidu = parseInt(lv);
                }
                else if (id == 'sixQMD') {
                    array[5].qinmidu = parseInt(lv);
                }
                sx(array)
            }
        },
        error: function (jqXHR) {
            //请求失败函数内容
        }
    });
}

/* 获取当前配置的属性ajax */
function sx(array) {
    sessionStorage.setItem('allData', JSON.stringify(array)); // 存储总数据
    // // 假的数据
    // var data = {
    //     "code": 1,
    //     "msg": "成功",
    //     "data": {
    //         "shuXingVo": {
    //             "qixue": 5806,
    //             "gongji": 200,
    //             "baoji": 134,
    //             "gedang": 70,
    //             "kangbao": 39,
    //             "fangyu": 0,
    //             "mingzhong": 72,
    //             "shanbi": 79,
    //             "pofang": 57
    //         },
    //         "pingfen": 4063,
    //         "jiachengMaps": {
    //             "qixue": 5806,
    //             "gongji": 200,
    //             "baoji": 134,
    //             "gedang": 70,
    //             "kangbao": 39,
    //             "fangyu": 0,
    //             "mingzhong": 72,
    //             "shanbi": 79,
    //             "pofang": 57
    //         }
    //     }
    // }

    // console.log(data)
    // var list = data.data
    // var pingfen = list.pingfen
    // var shuXingVo = list.shuXingVo
    // var jiachengMaps = list.jiachengMaps
    // // 评分
    // var list3 = '<div class="item">'+
    //             '<div>'+ pingfen + '</div>'+
    //             '</div>';
    // $('.list3').html(list3);
    // // 属性
    // var list1 = '<div class="item">'+
    //             '<div class="item-title">气血：</div>'+
    //             '<div class="item-value">'+ shuXingVo.qixue + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">攻击：</div>'+
    //             '<div class="item-value">'+ shuXingVo.gongji + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">命中：</div>'+
    //             '<div class="item-value">'+ shuXingVo.mingzhong + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">暴击：</div>'+
    //             '<div class="item-value">'+ shuXingVo.baoji + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">格挡：</div>'+
    //             '<div class="item-value">'+ shuXingVo.gedang + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">抗暴：</div>'+
    //             '<div class="item-value">'+ shuXingVo.kangbao + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">防御：</div>'+
    //             '<div class="item-value">'+ shuXingVo.fangyu + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">闪避：</div>'+
    //             '<div class="item-value">'+ shuXingVo.shanbi + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">破防：</div>'+
    //             '<div class="item-value">'+ shuXingVo.pofang + '</div>'+
    //             '</div>'
    // $('.list1').html(list1);
    // // 侠缘
    // var list2 = '<div class="item">'+
    //             '<div class="item-title">气血：</div>'+
    //             '<div class="item-value">'+ jiachengMaps.qixue + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">攻击：</div>'+
    //             '<div class="item-value">'+ jiachengMaps.gongji + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">命中：</div>'+
    //             '<div class="item-value">'+ jiachengMaps.mingzhong + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">暴击：</div>'+
    //             '<div class="item-value">'+ jiachengMaps.baoji + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">格挡：</div>'+
    //             '<div class="item-value">'+ jiachengMaps.gedang + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">抗暴：</div>'+
    //             '<div class="item-value">'+ jiachengMaps.kangbao + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">防御：</div>'+
    //             '<div class="item-value">'+ jiachengMaps.fangyu + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">闪避：</div>'+
    //             '<div class="item-value">'+ jiachengMaps.shanbi + '</div>'+
    //             '</div>'+
    //             '<div class="item">'+
    //             '<div class="item-title">破防：</div>'+
    //             '<div class="item-value">'+ jiachengMaps.pofang + '</div>'+
    //             '</div>'
    // $('.list2').html(list2);

    // 暂时没有数据我线用假的

    $.ajax({
        //请求方式
        type: 'POST',
        //发送请求的地址
        url: '/xajh/xkmnq/findPingfen',
        //服务器返回的数据类型
        dataType: 'json',
        contentType:"application/json;charset=utf-8",
        //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
        data: JSON.stringify(array),
        success: function (data) {
            //请求成功函数内容
            if (data.code == 1) {
                var list = data.data
                var pingfen = list.pingfen
                var shuXingVo = list.shuXingVo
                var jiachengMaps = list.jiachengMaps
                // 评分
                var list3 = '<div class="item">'+
                            '<div>'+ pingfen + '</div>'+
                            '</div>';
                $('.list3').html(list3);
                // 属性
                var list1 = '<div class="item">'+
                            '<div class="item-title">气血：</div>'+
                            '<div class="item-value">'+ shuXingVo.qixue + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">攻击：</div>'+
                            '<div class="item-value">'+ shuXingVo.gongji + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">命中：</div>'+
                            '<div class="item-value">'+ shuXingVo.mingzhong + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">暴击：</div>'+
                            '<div class="item-value">'+ shuXingVo.baoji + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">格挡：</div>'+
                            '<div class="item-value">'+ shuXingVo.gedang + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">抗暴：</div>'+
                            '<div class="item-value">'+ shuXingVo.kangbao + '</div>'+
                            '</div>'+
                            // '<div class="item">'+
                            // '<div class="item-title">防御：</div>'+
                            // '<div class="item-value">'+ shuXingVo.fangyu + '</div>'+
                            // '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">闪避：</div>'+
                            '<div class="item-value">'+ shuXingVo.shanbi + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">破防：</div>'+
                            '<div class="item-value">'+ shuXingVo.pofang + '</div>'+
                            '</div>'
                $('.list1').html(list1);
                // 侠缘
                $('.title1').html("侠缘加成：");
                var list2 = '<div class="item">'+
                            '<div class="item-title">气血：</div>'+
                            '<div class="item-value">'+ jiachengMaps.qixue + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">攻击：</div>'+
                            '<div class="item-value">'+ jiachengMaps.gongji + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">命中：</div>'+
                            '<div class="item-value">'+ jiachengMaps.mingzhong + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">暴击：</div>'+
                            '<div class="item-value">'+ jiachengMaps.baoji + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">格挡：</div>'+
                            '<div class="item-value">'+ jiachengMaps.gedang + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">抗暴：</div>'+
                            '<div class="item-value">'+ jiachengMaps.kangbao + '</div>'+
                            '</div>'+
                            // '<div class="item">'+
                            // '<div class="item-title">防御：</div>'+
                            // '<div class="item-value">'+ jiachengMaps.fangyu + '</div>'+
                            // '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">闪避：</div>'+
                            '<div class="item-value">'+ jiachengMaps.shanbi + '</div>'+
                            '</div>'+
                            '<div class="item">'+
                            '<div class="item-title">破防：</div>'+
                            '<div class="item-value">'+ jiachengMaps.pofang + '</div>'+
                            '</div>'
                $('.list2').html(list2);
            }
        },
        error: function (jqXHR) {
            //请求失败函数内容
        }
    });
}
/* 判断位置 */
function wz(data) {
    switch (data) {
        case 'one':
            return 1
        case 'two':
            return 2
        case 'three':
            return 3
        case 'four':
            return 4
        case 'five':
            return 5
        case 'six':
            return 6
    }
}