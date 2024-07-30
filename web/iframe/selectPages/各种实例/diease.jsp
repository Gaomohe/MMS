<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <div id="_page" style="margin: 0px auto; background: rgb(255, 255, 255); width: 210mm; min-height: 297mm; transform: scale(1, 1); transform-origin: 0px 0px 0px;" pagekind="A4" direct="portrait" data-startpage="0" data-startpos="0">
            <div id="_header" style="outline: none; min-height: 1.54cm; padding-left: 1.54cm; padding-right: 1.54cm; padding-top: 0.77cm; position: relative;" contenteditable="false" class="">
                <p style="text-align: center; font-family: 宋体; font-size: 10.5pt;"><label style="font-size: 10.5pt; font-weight: bold;">医疗机构</label><span style="font-size: 12pt;">
		</span><label style="font-family: Calibri; font-size: 10.5pt;">&nbsp;</label><span style="font-size: 12pt;">
		</span><label style="font-family: Calibri; font-size: 9pt;">&nbsp;</label><span style="font-size: 12pt;">&nbsp;<field tabindex="0" id="medins_name" name="medins_name" type="Text" contenteditable="false" class="blank input" title="医院名称" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 150px;">医院名称</field>&nbsp;</span><span style="font-size: 12pt;">&nbsp;</span><label style="font-size: 12pt; font-family: Calibri; font-weight: bold;">&nbsp;</label><span style="font-size: 12pt;">
		</span><label style="font-size: 9pt; font-weight: bold;">（</label><span style="font-size: 12pt;">
		</span><label style="font-size: 10.5pt; font-weight: bold;">组织机构编码：</label><span style="font-size: 12pt;">&nbsp;<field tabindex="0" id="medins_code" name="medins_code" type="Text" contenteditable="false" class="blank input" title="租户id" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 100px;">租户id</field>&nbsp;</span><span style="font-size: 12pt;">&nbsp;</span><label style="font-family: Calibri; font-size: 9pt; font-weight: bold;">&nbsp;</label><span style="font-size: 12pt;">
		</span><label style="font-size: 9pt; font-weight: bold;">）</label></p><p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><label style="font-size: 9pt; font-weight: bold;"><span style="font-size: 20px; text-align: start;">住 院 病 案 首 页</span></label></p></div>

            <div id="_body" style="min-height: calc(947.906px); padding-left: 1.54cm; padding-right: 1.54cm;" contenteditable="false" class=""><span>
	</span><p style=""><span>
		</span><label style=" font-family: 宋体; font-size: 9pt;">医疗付费方式：</label><span>
		</span><field tabindex="0" id="insutype" name="insutype" class="" style="font-family: 宋体; font-size: 9pt; border-bottom: 1px solid rgb(0, 0, 0);" type="DropdownList" data-list="[{&quot;value&quot;:&quot;0&quot;,&quot;text&quot;:&quot;自费&quot;},{&quot;value&quot;:&quot;310&quot;,&quot;text&quot;:&quot;职工基本医疗保险&quot;},{&quot;value&quot;:&quot;320&quot;,&quot;text&quot;:&quot;公务员医疗补助&quot;},{&quot;value&quot;:&quot;330&quot;,&quot;text&quot;:&quot;大额医疗费用补助&quot;},{&quot;value&quot;:&quot;340&quot;,&quot;text&quot;:&quot;离休人员医疗保障&quot;},{&quot;value&quot;:&quot;350&quot;,&quot;text&quot;:&quot;一至六级残废军人医疗补助&quot;},{&quot;value&quot;:&quot;390&quot;,&quot;text&quot;:&quot;城乡居民基本医疗保险&quot;},{&quot;value&quot;:&quot;392&quot;,&quot;text&quot;:&quot;城乡居民大病医疗保险&quot;},{&quot;value&quot;:&quot;510&quot;,&quot;text&quot;:&quot;生育保险&quot;}]" value="350" title="医保类型" domain="" code="" contenteditable="true" multi="false" required="false" data-expression="" selectable="false">一至六级残废军人医疗补助</field><span>&nbsp;<span>&nbsp;</span><br></span></p><p style=" font-family: 宋体; font-size: 9pt;"><label style=" font-family: 宋体; font-size: 9pt;">健康卡号：<field tabindex="0" id="card_no" name="card_no" type="Text" contenteditable="false" class="blank input" title="卡号" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 200px; border-bottom: 1px solid rgb(0, 0, 0);">卡号</field>&nbsp;</label><label style=" font-family: 宋体; font-size: 9pt;">第</label><label style="font-family: 宋体;"><field tabindex="0" id="patn_ipt_cnt" name="patn_ipt_cnt" type="Text" contenteditable="true" class="blank input" title="次" domain="emr_base_info" multiline="false" required="false" style="display: inline-block; min-width: 20px; text-align: center; border-bottom: 1px solid rgb(0, 0, 0);">次</field></label><label style=" font-family: 宋体; font-size: 9pt;">次住院</label><span>
		</span><label style=" font-family: Calibri; font-size: 9pt;">&nbsp;</label><span>
		</span><label style=" font-family: 宋体; font-size: 9pt;">  </label><span>
		</span><label style=" font-family: Calibri; font-size: 9pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><span>
		</span><label style=" font-family: 宋体; font-size: 9pt;">病案号：<field tabindex="0" id="ipt_no" name="ipt_no" type="Text" contenteditable="true" class="blank input" title="病案号" domain="" multiline="false" required="false" style="display: inline-block; min-width: 100px; border-bottom: 1px solid rgb(0, 0, 0);">病案号</field>&nbsp;</label></p><p style=" font-family: 宋体; font-size: 9pt;"><label style=" font-family: 宋体; font-size: 9pt;"><br></label></p><p style="font-family: 宋体; font-size: 10.5pt;"><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span><span>
		</span>    <table style="width: 677px; border-width: 1px; border-color: rgb(0, 0, 0); font-size: 10.5pt;" id="" title="" data-field="">
                <colgroup>
                    <col style="width: 72px;">
                    <col style="width: 62px;">
                    <col style="width: 93px;">
                    <col>
                    <col>
                    <col style="width: 60px;">
                    <col style="width: 56px;">
                    <col style="width: 48px;">
                    <col style="width: 51px;">
                    <col style="width: 71px;">
                    <col style="width: 15px;">
                    <col style="width: 66px;">
                </colgroup>
                <tbody style="">
                <tr style="">
                    <td colspan="12" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style="font-size: 10.5pt; font-family: 宋体;">
                            <label style=" font-family: 宋体; font-size: 10.5pt;">姓名：</label>
                            <field tabindex="0" id="psn_name" name="psn_name" type="Text" contenteditable="false" class="blank input" title="人员姓名" domain="" code="" multiline="false" required="true" format="text" inputmode="text" data-expression="" style="display: inline-block; min-width: 80px; border-bottom: 1px solid rgb(0, 0, 0);">人员姓名
                            </field>&nbsp;<label style=" font-family: 宋体; font-size: 10.5pt;"> 性别：</label>
                            <field tabindex="0" id="gend" name="gend" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 30px; border-bottom: 1px solid rgb(0, 0, 0);" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;男&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;女&quot;}]" value="2" title="男" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">男</field>
                            <label style=" font-family: 宋体; font-size: 10.5pt;">  出生日期：</label>
                            <field tabindex="0" class="" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 100px; border-bottom: 1px solid rgb(0, 0, 0);" id="brdy" name="brdy" type="DateTime" format="yyyy年MM月dd日" title="出生日期" domain="" code="" required="false" contenteditable="false" value="2024-07-01">2024年07月01日</field>
                            <label style=" font-family: 宋体; font-size: 10.5pt;"> 年龄：</label>
                            <field tabindex="0" id="age" name="age" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 30px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true" type="Text" title="年龄" domain="" multiline="false" required="false">年龄</field>&nbsp;<label style=" font-family: 宋体; font-size: 10.5pt;"> 国籍：</label><span style="color: rgb(211, 211, 211); background-color: rgb(238, 255, 255);">
                            <field tabindex="0" id="ntly" name="ntly" type="Text" contenteditable="false" class="blank input" title="国籍" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 76px; border-bottom: 1px solid rgb(0, 0, 0);">
                                国籍</field>
                        </span>
                        </p>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">（年龄不足1周岁的）年龄 </label><span>
                            <field tabindex="0" id="nwb_age" name="nwb_age" type="Text" contenteditable="false" class="blank input" title="1" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px; text-align: center;">
                                1</field>&nbsp;
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">月     新生儿出生体重 </label><span>
                            <field tabindex="0" id="nwb_bir_wt" name="nwb_bir_wt" type="Text" contenteditable="false" class="blank input" title="1" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 50px; border-bottom: 1px solid rgb(0, 0, 0); text-align: center;">
                                1</field>&nbsp;
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">克  新生儿入院体重</label><span>
                            <field tabindex="0" id="nwb_adm_wt" name="nwb_adm_wt" type="Text" contenteditable="false" class="blank input" title="1" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="text-align: center; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;">
                                1</field>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">克</label><span>
                        </span></p>
                        <p style=" font-family: 宋体; font-size: 10.5pt;">
                            <label style=" font-family: 宋体; font-size: 10.5pt;">出生地：<field tabindex="0" id="birplc" name="birplc" type="Text" contenteditable="false" class="blank input" title="出生地" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 200px; border-bottom: 1px solid rgb(0, 0, 0);">
                                出生地</field>&nbsp;</label><label style=" font-family: 宋体; font-size: 10.5pt;"> 籍贯：
                            <field tabindex="0" id="napl" name="napl" type="Text" contenteditable="false" class="blank input" title="籍贯" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 150px; border-bottom: 1px solid rgb(0, 0, 0);">
                                籍贯</field>&nbsp;民族：<field tabindex="0" id="naty" name="naty" type="DropdownList" contenteditable="false" class="blank input" data-list="[{&quot;value&quot;:&quot;01&quot;,&quot;text&quot;:&quot;汉族&quot;},{&quot;value&quot;:&quot;02&quot;,&quot;text&quot;:&quot;满族&quot;},{&quot;value&quot;:&quot;03&quot;,&quot;text&quot;:&quot;回族&quot;},{&quot;value&quot;:&quot;04&quot;,&quot;text&quot;:&quot;土家族&quot;},{&quot;value&quot;:&quot;05&quot;,&quot;text&quot;:&quot;藏族&quot;},{&quot;value&quot;:&quot;06&quot;,&quot;text&quot;:&quot;维吾尔族&quot;},{&quot;value&quot;:&quot;07&quot;,&quot;text&quot;:&quot;苗族&quot;},{&quot;value&quot;:&quot;08&quot;,&quot;text&quot;:&quot;彝（yí）族&quot;},{&quot;value&quot;:&quot;09&quot;,&quot;text&quot;:&quot;壮族&quot;},{&quot;value&quot;:&quot;10&quot;,&quot;text&quot;:&quot;布依族&quot;},{&quot;value&quot;:&quot;11&quot;,&quot;text&quot;:&quot;朝鲜族&quot;},{&quot;value&quot;:&quot;12&quot;,&quot;text&quot;:&quot;哈尼族&quot;},{&quot;value&quot;:&quot;13&quot;,&quot;text&quot;:&quot;侗（dòng）族&quot;},{&quot;value&quot;:&quot;14&quot;,&quot;text&quot;:&quot;瑶族&quot;},{&quot;value&quot;:&quot;15&quot;,&quot;text&quot;:&quot;白族&quot;},{&quot;value&quot;:&quot;16&quot;,&quot;text&quot;:&quot;蒙古族&quot;},{&quot;value&quot;:&quot;17&quot;,&quot;text&quot;:&quot;哈萨克族&quot;},{&quot;value&quot;:&quot;18&quot;,&quot;text&quot;:&quot;傣族&quot;},{&quot;value&quot;:&quot;19&quot;,&quot;text&quot;:&quot;黎族&quot;},{&quot;value&quot;:&quot;20&quot;,&quot;text&quot;:&quot;傈僳族&quot;},{&quot;value&quot;:&quot;21&quot;,&quot;text&quot;:&quot;佤族&quot;},{&quot;value&quot;:&quot;22&quot;,&quot;text&quot;:&quot;畲族&quot;},{&quot;value&quot;:&quot;23&quot;,&quot;text&quot;:&quot;高山族&quot;},{&quot;value&quot;:&quot;24&quot;,&quot;text&quot;:&quot;拉祜族&quot;},{&quot;value&quot;:&quot;25&quot;,&quot;text&quot;:&quot;水族&quot;},{&quot;value&quot;:&quot;26&quot;,&quot;text&quot;:&quot;东乡族&quot;},{&quot;value&quot;:&quot;27&quot;,&quot;text&quot;:&quot;纳西族&quot;},{&quot;value&quot;:&quot;28&quot;,&quot;text&quot;:&quot;景颇族&quot;},{&quot;value&quot;:&quot;29&quot;,&quot;text&quot;:&quot;柯尔克孜族&quot;},{&quot;value&quot;:&quot;30&quot;,&quot;text&quot;:&quot;土族&quot;},{&quot;value&quot;:&quot;31&quot;,&quot;text&quot;:&quot;达斡尔族&quot;},{&quot;value&quot;:&quot;32&quot;,&quot;text&quot;:&quot;仫佬族&quot;},{&quot;value&quot;:&quot;33&quot;,&quot;text&quot;:&quot;羌族&quot;},{&quot;value&quot;:&quot;34&quot;,&quot;text&quot;:&quot;布朗族&quot;},{&quot;value&quot;:&quot;35&quot;,&quot;text&quot;:&quot;撒拉族&quot;},{&quot;value&quot;:&quot;36&quot;,&quot;text&quot;:&quot;毛难族&quot;},{&quot;value&quot;:&quot;37&quot;,&quot;text&quot;:&quot;仡佬族&quot;},{&quot;value&quot;:&quot;38&quot;,&quot;text&quot;:&quot;锡伯族&quot;},{&quot;value&quot;:&quot;39&quot;,&quot;text&quot;:&quot;阿昌族&quot;},{&quot;value&quot;:&quot;40&quot;,&quot;text&quot;:&quot;普米族&quot;},{&quot;value&quot;:&quot;41&quot;,&quot;text&quot;:&quot;塔吉克族&quot;},{&quot;value&quot;:&quot;42&quot;,&quot;text&quot;:&quot;怒族&quot;},{&quot;value&quot;:&quot;43&quot;,&quot;text&quot;:&quot;乌孜别克族&quot;},{&quot;value&quot;:&quot;44&quot;,&quot;text&quot;:&quot;俄罗斯族&quot;},{&quot;value&quot;:&quot;45&quot;,&quot;text&quot;:&quot;鄂温克族&quot;},{&quot;value&quot;:&quot;46&quot;,&quot;text&quot;:&quot;德昂族&quot;},{&quot;value&quot;:&quot;47&quot;,&quot;text&quot;:&quot;保安族&quot;},{&quot;value&quot;:&quot;48&quot;,&quot;text&quot;:&quot;裕固族&quot;},{&quot;value&quot;:&quot;49&quot;,&quot;text&quot;:&quot;京族&quot;},{&quot;value&quot;:&quot;50&quot;,&quot;text&quot;:&quot;塔塔尔族&quot;},{&quot;value&quot;:&quot;51&quot;,&quot;text&quot;:&quot;独龙族&quot;},{&quot;value&quot;:&quot;52&quot;,&quot;text&quot;:&quot;鄂伦春族&quot;},{&quot;value&quot;:&quot;53&quot;,&quot;text&quot;:&quot;赫哲族&quot;},{&quot;value&quot;:&quot;54&quot;,&quot;text&quot;:&quot;门巴族&quot;},{&quot;value&quot;:&quot;55&quot;,&quot;text&quot;:&quot;珞巴族&quot;},{&quot;value&quot;:&quot;56&quot;,&quot;text&quot;:&quot;基诺族&quot;}]" title="汉族" domain="" code="" multi="false" required="false" data-expression="" style="display: inline-block; min-width: 30px; border-bottom: 1px solid rgb(0, 0, 0);">
                                汉族</field>&nbsp;&nbsp;</label></p>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><label style=" font-family: 宋体; font-size: 10.5pt;">证件号码：<field tabindex="0" id="certno" name="certno" type="Text" contenteditable="false" class="blank input" title="证件号码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 160px; border-bottom: 1px solid rgb(0, 0, 0);">
                            证件号码</field></label><label style=" font-family: 宋体; font-size: 10.5pt;">职业：</label>
                            <field tabindex="0" id="prfs" name="prfs" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 70px; border-bottom: 1px solid rgb(0, 0, 0);" type="DropdownList" value="" title="职业" data-code="" data-expression="" event="undefined" multi="false" validate="false" data-show-vaule="" data-show-id="" domain="" code="" contenteditable="false" required="false" data-list="[{&quot;value&quot;:&quot;0001&quot;,&quot;text&quot;:&quot;农民&quot;},{&quot;value&quot;:&quot;0002&quot;,&quot;text&quot;:&quot;工人&quot;},{&quot;value&quot;:&quot;0003&quot;,&quot;text&quot;:&quot;教师&quot;},{&quot;value&quot;:&quot;0004&quot;,&quot;text&quot;:&quot;医生&quot;}]">职业</field><label style=" font-family: 宋体; font-size: 10.5pt;">婚姻 </label><span>
                        </span>
                            <field tabindex="0" id="mrg_stas" name="mrg_stas" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 33px; border-bottom: 1px solid rgb(0, 0, 0);" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;未婚&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;已婚&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;丧偶&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;离婚&quot;},{&quot;value&quot;:&quot;9&quot;,&quot;text&quot;:&quot;其他&quot;}]" value="2" title="未婚" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">未婚</field><span>
                            1.未婚 2.已婚 3.丧偶 4.离婚 9.其他</span>
                        </p>
                        <p style="font-size: 10.5pt; font-family: 宋体;" title="1" contenteditable="false"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">现住址：</label>
                            <field tabindex="0" id="curr_addr" name="curr_addr" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 250px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="现住址" data-code="" data-expression="" multiline="false" validate="false" format="" domain="" code="" required="false" inputmode="">现住址</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 电话：</label>
                            <field tabindex="0" id="psn_tel" name="psn_tel" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 100px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="电话" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">电话</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">  邮编 </label><span>
                        </span>
                            <field tabindex="0" id="curr_addr_poscode" name="curr_addr_poscode" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 76px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="现住址邮编" data-code="" data-expression="" multiline="false" validate="false" format="" domain="" code="" required="false" inputmode="">现住址邮编</field><span>
                        </span>
                        </p>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">户口地址：</label>
                            <field tabindex="0" id="resd_addr" name="resd_addr" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 236px;" contenteditable="false" type="Text" title="户口地址" data-code="" data-expression="" multiline="false" validate="false" format="" domain="" code="" required="false" inputmode="">户口地址</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 邮编 </label><span>
                        </span>
                            <field tabindex="0" id="resd_addr_poscode" name="resd_addr_poscode" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 89px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="户口住址邮编" data-code="" data-expression="" multiline="false" validate="false" format="" domain="" code="" required="false" inputmode="">户口住址邮编</field><span>
                        </span>
                        </p>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">工作单位及地址：<field tabindex="0" id="empr_addr" name="empr_addr" type="Text" contenteditable="false" class="blank input" title="单位地址" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 193px;">
                            单位地址</field>&nbsp;</label><label style=" font-family: 宋体; font-size: 10.5pt;">单位电话 </label><span>
                        </span>
                            <field tabindex="0" id="empr_tel" name="empr_tel" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 87px;" contenteditable="false" type="Text" title="单位电话" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">单位电话</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">邮编 </label><span>
                        </span>
                            <field tabindex="0" id="empr_poscode" name="empr_poscode" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 76px;" contenteditable="false" type="Text" title="单位地址邮编" data-code="" data-expression="" multiline="false" validate="false" format="" domain="" code="" required="false" inputmode="">单位地址邮编</field><span>
                        </span>
                        </p>
                        <p style=" font-family: 宋体; font-size: 10.5pt;">
                            <label style=" font-family: 宋体; font-size: 10.5pt;">联系人姓名：</label>
                            <field tabindex="0" id="coner_name" name="coner_name" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 59px;" contenteditable="false" type="Text" title="张三" data-code="" data-expression="" multiline="false" validate="false" format="" domain="" code="" required="false" inputmode="">张三</field>
                            <label style=" font-family: 宋体; font-size: 10.5pt;">关系：<field tabindex="0" id="coner_rlts_code" name="coner_rlts_code" type="Text" contenteditable="false" class="blank input" title="关系" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;">
                                关系</field>&nbsp;</label><label style=" font-family: 宋体; font-size: 10.5pt;">地址 ：</label>
                            <field tabindex="0" id="coner_addr" name="coner_addr" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 171px;" contenteditable="false" type="Text" title="联系人地址" data-code="" data-expression="" multiline="false" validate="false" format="" domain="" code="" required="false" inputmode="">联系人地址</field>
                            <label style=" font-family: 宋体; font-size: 10.5pt;">电话：<field tabindex="0" id="coner_tel" name="coner_tel" type="Text" contenteditable="false" class="blank input" title="联系人电话" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 86px;">
                                联系人电话</field>&nbsp;</label>
                        </p>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">入院途径： </label><span>
                        </span>
                            <field tabindex="0" id="adm_way_code" name="adm_way_code" class="blank" style="font-family: 宋体; font-size: 10.5pt; text-align: center; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 48px;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-急诊&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-门诊&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-其他医疗机构转入&quot;},{&quot;value&quot;:&quot;9&quot;,&quot;text&quot;:&quot;9-其他&quot;}]" value="2" title="1-急诊" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-急诊</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 1.急诊 2.门诊 3.其他医疗机构转入
                                9.其他</label><label style=" font-family: 宋体; font-size: 10.5pt;"> </label>
                        </p>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">入院时间： </label>
                            <field tabindex="0" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 100px;" id="adm_date" name="adm_date" type="DateTime" format="null" title="入    院    时    间" domain="" code="" required="false" contenteditable="false" readonly="true">入 院 时 间</field>
                            <span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 入院科别 </label><span>
                        </span>
                            <field tabindex="0" id="adm_caty" name="adm_caty" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 70px;" type="DropdownList" value="" title="入院科别" data-code="" data-expression="" event="undefined" multi="false" validate="false" data-show-vaule="" data-show-id="" domain="" code="" contenteditable="false" required="false">入院科别</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 病房 </label><span>
                        </span>
                            <field tabindex="0" id="adm_ward" name="adm_ward" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 70px;" contenteditable="false" type="Text" title="入院病房" data-code="" data-expression="" multiline="false" validate="false" format="" domain="" code="" required="false" inputmode="">入院病房</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 转科科别 </label><span>&nbsp;
                            <field tabindex="0" id="Refldept_caty_name" name="Refldept_caty_name" type="Text" contenteditable="false" class="blank input" title="转科科别" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 70px;">
                                转科科别</field>&nbsp;</span>
                            <field tabindex="0" id="PA_DISPLACE_KB_NAME" name="PA_DISPLACE_KB_NAME" class="" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="true" type="Text" value="文本框&nbsp;" title="转科科别"><label style=" font-family: 宋体; font-size: 10.5pt;"></label>
                            </field>
                        </p>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">出院时间： </label>
                            <field tabindex="0" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 100px; border-bottom: 1px solid rgb(0, 0, 0);" id="dscg_date" name="dscg_date" type="DateTime" format="null" title="出    院    时    间" domain="" code="" required="false" contenteditable="false" readonly="true">出 院 时 间</field>
                            <span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 出院科别 </label><span>
                        </span>
                            <field tabindex="0" id="dscg_caty" name="dscg_caty" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 70px; border-bottom: 1px solid rgb(0, 0, 0);" type="DropdownList" value="" title="出院科别" data-code="" data-expression="" event="undefined" multi="false" validate="false" data-show-vaule="" data-show-id="" domain="" code="" contenteditable="false" required="false">出院科别</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 病房 </label><span>
                        </span>
                            <field tabindex="0" id="dscg_ward" name="dscg_ward" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 70px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="出院病房" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">出院病房</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 实际住院 </label><span>
                        </span>
                            <field tabindex="0" id="ipt_days" name="ipt_days" class="blank" style="font-family: 宋体; font-size: 10.5pt; text-align: center; display: inline-block; min-width: 20px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="1" data-code="" data-expression="" multiline="false" validate="false" format="" domain="" code="" required="false" inputmode="">1</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 天</label><span>
                        </span>
                        </p>
                        <p style=""><span>
                        </span><label style="">门（急）诊诊断 </label><span>
                        </span>
                            <field tabindex="0" id="dise_name" name="dise_name" class="blank" type="Text" title="诊断名称" multi="false" validate="false" domain="" contenteditable="false" required="false" multiline="false" code="" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 200px; border-bottom: 1px solid rgb(0, 0, 0);">诊断名称</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 疾病编码 </label><span>
                        </span>
                            <field tabindex="0" id="wm_dise_cod" name="wm_dise_cod" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 100px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="icd9" data-code="" data-expression="" multiline="false" validate="false" format="" domain="" code="" required="false" inputmode="">icd9</field>
                        </p>
                    </td>
                </tr>
                <tr style="height: 47px">
                    <td colspan="3" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">出院诊断</label></p>
                    </td>
                    <td colspan="2" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">疾病编码</label></p>
                    </td>
                    <td class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">入院</label><span>
                        </span></p>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">病情</label></p>
                    </td>
                    <td colspan="3" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">出院诊断</label></p>
                    </td>
                    <td colspan="2" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">疾病编码</label></p>
                    </td>
                    <td style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">入院病情</label></p>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">主要诊断：<field tabindex="0" id="wm_diag_name-0" name="wm_diag_name-0" type="Text" contenteditable="false" class="blank input" title="主要诊断" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">主要诊断</field>&nbsp;</label></p>
                    </td>
                    <td colspan="2" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-0" name="wm_diag_code-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-0" name="adm_cond_code-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="1" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                    <td colspan="3" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">其他诊断</label><span>&nbsp;
                            <!--StartFragment-->
                            <field tabindex="0" id="wm_diag_name-10" name="wm_diag_name-10" type="DataList" contenteditable="false" class="input blank" title="其他诊断" data="" validate="false" data-code="" data-codepos="1" required="false" domain="" code="">其他诊断</field>&nbsp;
                            <!--EndFragment-->

                        </span></p>
                    </td>
                    <td colspan="2" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-10" name="wm_diag_code-10" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-10" name="adm_cond_code-10" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                </tr>
                <tr style="height: 26px">
                    <td colspan="3" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">其他诊断：<field tabindex="0" id="wm_diag_name-1" name="wm_diag_name-1" type="Text" contenteditable="false" class="blank input" title="其他诊断" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">其他诊断</field>&nbsp;</label></p>
                    </td>
                    <td colspan="2" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-1" name="wm_diag_code-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-1" name="adm_cond_code-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="1" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                    <td colspan="3" class="" style="border-color: rgb(0, 0, 0);">
                        <p style=" font-family: 宋体; font-size: 10.5pt;">
                            <field tabindex="0" id="zd12_mc" name="zd12_mc" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="诊断信息">

                                <!--StartFragment-->
                                <field tabindex="0" id="wm_diag_name-11" name="wm_diag_name-11" type="DataList" contenteditable="false" class="input blank" title="诊断信息" data="" validate="false" data-code="" data-codepos="1" required="false" domain="" code="">诊断信息</field>
                                <!--EndFragment-->

                            </field>
                        </p>
                    </td>
                    <td colspan="2" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-11" name="wm_diag_code-11" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-11" name="adm_cond_code-11" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="zd2_bq" name="zd2_bq" class="" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;1-有&quot;,&quot;value&quot;:&quot;1&quot;},{&quot;text&quot;:&quot;2-临床未确定&quot;,&quot;value&quot;:&quot;2&quot;},{&quot;text&quot;:&quot;3-情况不明&quot;,&quot;value&quot;:&quot;3&quot;},{&quot;text&quot;:&quot;4-无&quot;,&quot;value&quot;:&quot;4&quot;}]" value="1" title="1-有"></field>
                        <span>
                    </span><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-2" name="wm_diag_name-2" type="DataList" contenteditable="false" class="input blank" title="诊断信息" data="" validate="false" data-code="" data-codepos="1" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-2" name="wm_diag_code-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-2" name="adm_cond_code-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                    <td colspan="3" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>

                        <!--StartFragment-->

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-12" name="wm_diag_name-12" type="DataList" contenteditable="false" class="blank input" title="诊断信息" data="" validate="false" data-code="" data-codepos="0" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-12" name="wm_diag_code-12" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-12" name="adm_cond_code-12" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="zd2_bq" name="zd2_bq" class="" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;1-有&quot;,&quot;value&quot;:&quot;1&quot;},{&quot;text&quot;:&quot;2-临床未确定&quot;,&quot;value&quot;:&quot;2&quot;},{&quot;text&quot;:&quot;3-情况不明&quot;,&quot;value&quot;:&quot;3&quot;},{&quot;text&quot;:&quot;4-无&quot;,&quot;value&quot;:&quot;4&quot;}]" value="1" title="1-有"></field>
                        <span>
                    </span><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-3" name="wm_diag_name-3" type="DataList" contenteditable="false" class="input blank" title="诊断信息" data="" validate="false" data-code="" data-codepos="1" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-3" name="wm_diag_code-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-3" name="adm_cond_code-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-13" name="wm_diag_name-13" type="DataList" contenteditable="false" class="blank input" title="诊断信息" data="" validate="false" data-code="" data-codepos="0" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-13" name="wm_diag_code-13" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-13" name="adm_cond_code-13" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="zd2_bq" name="zd2_bq" class="" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;1-有&quot;,&quot;value&quot;:&quot;1&quot;},{&quot;text&quot;:&quot;2-临床未确定&quot;,&quot;value&quot;:&quot;2&quot;},{&quot;text&quot;:&quot;3-情况不明&quot;,&quot;value&quot;:&quot;3&quot;},{&quot;text&quot;:&quot;4-无&quot;,&quot;value&quot;:&quot;4&quot;}]" value="1" title="1-有"></field>
                        <span>
                    </span><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-4" name="wm_diag_name-4" type="DataList" contenteditable="false" class="input blank" title="诊断信息" data="" validate="false" data-code="" data-codepos="1" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-4" name="wm_diag_code-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-4" name="adm_cond_code-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-14" name="wm_diag_name-14" type="DataList" contenteditable="false" class="blank input" title="诊断信息" data="" validate="false" data-code="" data-codepos="0" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-14" name="wm_diag_code-14" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-14" name="adm_cond_code-14" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="zd2_bq" name="zd2_bq" class="" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;1-有&quot;,&quot;value&quot;:&quot;1&quot;},{&quot;text&quot;:&quot;2-临床未确定&quot;,&quot;value&quot;:&quot;2&quot;},{&quot;text&quot;:&quot;3-情况不明&quot;,&quot;value&quot;:&quot;3&quot;},{&quot;text&quot;:&quot;4-无&quot;,&quot;value&quot;:&quot;4&quot;}]" value="1" title="1-有"></field>
                        <span>
                    </span><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-5" name="wm_diag_name-5" type="DataList" contenteditable="false" class="input blank" title="诊断信息" data="" validate="false" data-code="" data-codepos="1" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><field tabindex="0" id="wm_diag_code-5" name="wm_diag_code-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-5" name="adm_cond_code-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-15" name="wm_diag_name-15" type="DataList" contenteditable="false" class="blank input" title="诊断信息" data="" validate="false" data-code="" data-codepos="0" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-15" name="wm_diag_code-15" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-15" name="adm_cond_code-15" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="zd2_bq" name="zd2_bq" class="" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;1-有&quot;,&quot;value&quot;:&quot;1&quot;},{&quot;text&quot;:&quot;2-临床未确定&quot;,&quot;value&quot;:&quot;2&quot;},{&quot;text&quot;:&quot;3-情况不明&quot;,&quot;value&quot;:&quot;3&quot;},{&quot;text&quot;:&quot;4-无&quot;,&quot;value&quot;:&quot;4&quot;}]" value="1" title="1-有"></field>
                        <span>
                    </span><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-6" name="wm_diag_name-6" type="DataList" contenteditable="false" class="input blank" title="诊断信息" data="" validate="false" data-code="" data-codepos="1" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-6" name="wm_diag_code-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-6" name="adm_cond_code-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-16" name="wm_diag_name-16" type="DataList" contenteditable="false" class="blank input" title="诊断信息" data="" validate="false" data-code="" data-codepos="0" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-16" name="wm_diag_code-16" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-16" name="adm_cond_code-16" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="zd2_bq" name="zd2_bq" class="" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;1-有&quot;,&quot;value&quot;:&quot;1&quot;},{&quot;text&quot;:&quot;2-临床未确定&quot;,&quot;value&quot;:&quot;2&quot;},{&quot;text&quot;:&quot;3-情况不明&quot;,&quot;value&quot;:&quot;3&quot;},{&quot;text&quot;:&quot;4-无&quot;,&quot;value&quot;:&quot;4&quot;}]" value="1" title="1-有"></field>
                        <span>
                    </span><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-7" name="wm_diag_name-7" type="DataList" contenteditable="false" class="input blank" title="诊断信息" data="" validate="false" data-code="" data-codepos="1" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-7" name="wm_diag_code-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-7" name="adm_cond_code-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-17" name="wm_diag_name-17" type="DataList" contenteditable="false" class="blank input" title="诊断信息" data="" validate="false" data-code="" data-codepos="0" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-17" name="wm_diag_code-17" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-17" name="adm_cond_code-17" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="zd2_bq" name="zd2_bq" class="" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;1-有&quot;,&quot;value&quot;:&quot;1&quot;},{&quot;text&quot;:&quot;2-临床未确定&quot;,&quot;value&quot;:&quot;2&quot;},{&quot;text&quot;:&quot;3-情况不明&quot;,&quot;value&quot;:&quot;3&quot;},{&quot;text&quot;:&quot;4-无&quot;,&quot;value&quot;:&quot;4&quot;}]" value="1" title="1-有"></field>
                        <span>
                    </span><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-8" name="wm_diag_name-8" type="DataList" contenteditable="false" class="input blank" title="诊断信息" data="" validate="false" data-code="" data-codepos="1" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-8" name="wm_diag_code-8" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-8" name="adm_cond_code-8" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-18" name="wm_diag_name-18" type="DataList" contenteditable="false" class="blank input" title="诊断信息" data="" validate="false" data-code="" data-codepos="0" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-18" name="wm_diag_code-18" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-18" name="adm_cond_code-18" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                </tr>
                <tr class="" style="height: 26px">
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="zd2_bq" name="zd2_bq" class="" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;1-有&quot;,&quot;value&quot;:&quot;1&quot;},{&quot;text&quot;:&quot;2-临床未确定&quot;,&quot;value&quot;:&quot;2&quot;},{&quot;text&quot;:&quot;3-情况不明&quot;,&quot;value&quot;:&quot;3&quot;},{&quot;text&quot;:&quot;4-无&quot;,&quot;value&quot;:&quot;4&quot;}]" value="1" title="1-有"></field>
                        <span>
                    </span><span>
                    </span>

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-9" name="wm_diag_name-9" type="DataList" contenteditable="false" class="input blank" title="诊断信息" data="" validate="false" data-code="" data-codepos="1" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-9" name="wm_diag_code-9" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-9" name="adm_cond_code-9" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                    <td colspan="3" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>

                        <!--StartFragment-->

                        <!--StartFragment-->
                        <field tabindex="0" id="wm_diag_name-19" name="wm_diag_name-19" type="DataList" contenteditable="false" class="blank input" title="诊断信息" data="" validate="false" data-code="" data-codepos="0" style="" required="false" domain="" code="">诊断信息</field>
                    </td>
                    <td colspan="2" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="wm_diag_code-19" name="wm_diag_code-19" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">疾病编码</field>
                        </p>
                    </td>
                    <td colspan="1" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span>
                            <field tabindex="0" id="adm_cond_code-19" name="adm_cond_code-19" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-有&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-临床未确定&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-情况不明&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-无&quot;}]" value="" title="1-有" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-有</field>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td colspan="6" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">入院rere病情：1.有，rere2.临床未确定，3.情况不明，4.无</label>
                        </p>
                    </td>
                    <td colspan="3" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><br></p>
                    </td>
                    <td colspan="2" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><br></p>
                    </td>
                    <td style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><br></p>
                    </td>
                </tr>
                <tr style="height: 30px">
                    <td colspan="12" style="border-color: rgb(0, 0, 0);" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Justify;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">损伤、 中毒的外部原因 </label><span>
                            <field tabindex="0" id="damg_intx_ext_rea" name="damg_intx_ext_rea" type="Text" contenteditable="true" class="blank input" title="损伤、中毒的外部原因" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 200px;">
                                损伤、中毒的外部原因</field>&nbsp;
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 疾病编码 </label><span>
                        </span>
                            <field tabindex="0" id="diag_code" name="diag_code" class="blank" style="font-family: 宋体; font-size: 10.5pt; display: inline-block; min-width: 100px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true" type="Text" title="中毒疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">中毒疾病编码</field>
                        </p>
                    </td>
                </tr>
                <tr style="height: 1.07627cm">
                    <td colspan="12" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">病理诊断：<field tabindex="0" id="palg_diag" name="palg_diag" type="Text" contenteditable="true" class="blank input" title="病理诊断" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 220px;">
                            病理诊断&nbsp;</field></label><label style=" font-family: 宋体; font-size: 10.5pt;">疾病编码：</label>
                            <field tabindex="0" id="diag_code" name="diag_code" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 100px;" contenteditable="true" type="Text" title="病理疾病编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">病理疾病编码</field><label style="font-size: 10.5pt;">病理号：</label>
                            <field tabindex="0" id="palg_no" name="palg_no" class="blank" type="Text" title="病理号" data-code="" data-expression="" multiline="false" validate="false" format="" style="font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 100px;" domain="" code="" contenteditable="true" required="false" inputmode="">病理号</field><span style="font-size: 10.5pt;">&nbsp;</span>
                        </p>
                    </td>
                </tr>
                <tr style="height: 0.635593cm">
                    <td colspan="12" style="border-color: rgb(0, 0, 0);"><span>
                    </span>
                        <p style="font-family: 宋体; text-align: justify;">

                            <!--StartFragment--><label style="font-family: 宋体; color: rgb(32, 31, 53); font-size: 10.5pt;">物过敏</label>
                            <label style="font-size: 9pt; font-family: 宋体; color: rgb(32, 31, 53);"> </label>
                            <field tabindex="0" class="blank" style="font-size: 7.5pt; font-family: 宋体; color: rgb(32, 31, 53); text-align: center; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 20px;" contenteditable="true" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2&quot;}]" value="" title="1" id="drug_dicm_flag" name="drug_dicm_flag" domain="" code="" multi="false" required="false" data-expression="">1</field>
                            <label style="font-size: 9pt; font-family: 宋体; color: rgb(32, 31, 53);"> 1.无2.有，过敏药物：</label>
                            <field tabindex="0" id="gmyw" name="gmyw" class="" style="font-size: 9pt; font-family: 宋体; color: rgb(32, 31, 53);" contenteditable="true" type="Text" value="过敏药物" title="-"><label style=" font-family: 宋体; font-size: 9pt; color: #201F35;">
                                <field tabindex="0" id="dicm_drug_name" name="dicm_drug_name" type="Text" contenteditable="true" class="blank input" title="过敏药物" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 204px; border-bottom: 1px solid rgb(0, 0, 0);">
                                    过敏药物</field>
                            </label></field><span style="font-size: 10.5pt;">&nbsp;</span><label style="font-size: 9pt; font-family: 宋体; color: rgb(32, 31, 53);"> </label>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53); font-size: 10.5pt;">死亡患者尸检</label>
                            <label style="font-size: 9pt; font-family: 宋体; color: rgb(32, 31, 53);"> </label>
                            <field tabindex="0" class="blank" style="font-size: 7.5pt; font-family: 宋体; color: rgb(32, 31, 53); display: inline-block; min-width: 20px; text-align: center; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2&quot;}]" value="" title="1" id="die_autp_flag" name="die_autp_flag" domain="" code="" multi="false" required="false" data-expression="">1</field>
                            <label style="font-size: 9pt; font-family: 宋体; color: rgb(32, 31, 53);"> 1.是 2.否</label>
                            <!--EndFragment-->

                            <span style="font-size: 10.5pt;"><br></span>
                        </p>
                    </td>
                </tr>
                <tr style="height: 0.686441cm">
                    <td colspan="12" style="border-color: rgb(0, 0, 0);">
                        <p style="font-family: 宋体; text-align: justify;">

                            <!--StartFragment--><label style="font-family: 宋体; color: rgb(32, 31, 53); font-size: 10.5pt;">血型</label><label style="font-size: 9pt; font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;"> </label>
                            <field tabindex="0" class="blank" style="font-size: 7.5pt; font-family: 宋体; color: rgb(32, 31, 53); display: inline-block; min-width: 20px; text-align: center; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4&quot;},{&quot;value&quot;:&quot;5&quot;,&quot;text&quot;:&quot;5&quot;},{&quot;value&quot;:&quot;6&quot;,&quot;text&quot;:&quot;6&quot;}]" value="" title="1" id="abo_code" name="abo_code" domain="" code="" multi="false" required="false" data-expression="">1</field>
                            <label style="font-size: 9pt; font-family: 宋体;"> 1.A  2.B  3.O  4.AB  5.不详  6.未查                   </label>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53); font-size: 10.5pt;">Rh</label><label style="font-size: 9pt; font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;"> </label>
                            <field tabindex="0" class="blank" style="font-size: 7.5pt; font-family: 宋体; color: rgb(32, 31, 53); display: inline-block; min-width: 20px; text-align: center; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4&quot;}]" value="" title="1" id="rh_code" name="rh_code" domain="" code="" multi="false" required="false" data-expression="">1</field>
                            <label style="font-size: 9pt; font-family: 宋体; color: rgb(32, 31, 53);">  1.阴  2.阳  3.不详  4.未查</label>
                            <!--EndFragment-->

                        </p>
                    </td>
                </tr>
                <tr style="height: 47px">
                    <td colspan="12" class="" style="border-color: rgb(0, 0, 0);">
                        <p style="font-family: 宋体; text-align: justify;"><label style="color: rgb(32, 31, 53); font-size: 10.5pt;">科主任</label><label style="font-size: 9pt;"><span style="font-weight: bold;">&nbsp;&nbsp;</span>
                            <field tabindex="0" id="deptdrt_name" name="deptdrt_name" type="Text" class="blank input" title="科主任" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 60px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true">科主任</field><span style="font-weight: bold;">&nbsp;</span>
                        </label><span style="font-size: 12pt;">&nbsp;</span><label style="font-size: 9pt; color: rgb(32, 31, 53);"> </label><label style="color: rgb(32, 31, 53); font-size: 10.5pt;">主任（副主任）医师</label><span style="font-size: 12pt;">&nbsp;</span>
                            <field tabindex="0" id="chfdr_name" name="chfdr_name" type="Text" class="blank input" title="副主任" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="font-size: 9pt; display: inline-block; min-width: 60px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true">副主任</field><span style="font-size: 12pt;">&nbsp;</span><label style="font-size: 10.5pt; color: rgb(32, 31, 53);">主治医师</label><label style="font-size: 12pt;"><span style="font-size: 10.5pt;">&nbsp;</span>
                                <field tabindex="0" id="atddr_name" name="atddr_name" type="Text" class="blank input" title="主治医师" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="border-bottom: 1px solid rgb(0, 0, 0); font-size: 9pt;" contenteditable="true">主治医师</field><span style="font-size: 10.5pt;">&nbsp;</span>
                            </label><span style="font-size: 10.5pt;">&nbsp;</span><label style="font-size: 10.5pt; color: rgb(32, 31, 53);">住院医师</label><span style="font-size: 9pt;">
                            &nbsp;<field tabindex="0" id="ipt_dr_name" name="ipt_dr_name" type="Text" class="blank input" title="住院医师" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 60px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true">住院医师</field></span>
                        </p>
                        <p style="font-family: 宋体;">
                            <label style="font-size: 10.5pt; font-family: 宋体; color: rgb(32, 31, 53);">责任护士</label>
                            <field tabindex="0" id="zrhs" name="zrhs" class="" style="font-family: 宋体; color: rgb(32, 31, 53);" contenteditable="true" type="Text" value="责任护士" title="-"><label style="font-family: 宋体; color: rgb(32, 31, 53);">
                                <field tabindex="0" id="resp_nurs_name" name="resp_nurs_name" type="Text" contenteditable="true" class="blank input" title="责任护士" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 60px; border-bottom: 1px solid rgb(0, 0, 0); font-size: 9pt;">
                                    责任护士</field>
                            </label></field><span style="font-size: 10.5pt;">&nbsp; &nbsp;</span><label style="font-size: 10.5pt; font-family: 宋体; color: rgb(32, 31, 53);">进修医师</label>
                            <field tabindex="0" id="train_dr_name" name="train_dr_name" type="Text" contenteditable="true" class="blank input" title="进修医师" style="font-size: 9pt; display: inline-block; min-width: 60px; border-bottom: 1px solid rgb(0, 0, 0);" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">进修医师</field>&nbsp;<span style="font-size: 10.5pt;">&nbsp; &nbsp; &nbsp;
                            &nbsp;</span><label style="font-size: 10.5pt; font-family: 宋体; color: rgb(32, 31, 53);">实习医师&nbsp;</label>
                            <field tabindex="0" id="sxys" name="sxys" class="" style="font-family: 宋体; color: rgb(32, 31, 53);" contenteditable="true" type="Text" value="实习医师" title="-"><label style="font-family: 宋体; color: rgb(32, 31, 53);">
                                <field tabindex="0" id="intn_dr_name" name="intn_dr_name" type="Text" contenteditable="true" class="blank input" title="实习医师" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 60px; border-bottom: 1px solid rgb(0, 0, 0); font-size: 9pt;">
                                    实习医师</field>
                            </label></field><label style="font-size: 10.5pt; font-family: 宋体;">&nbsp;&nbsp;</label><label style="font-size: 10.5pt; font-family: 宋体; color: rgb(32, 31, 53);">编码员&nbsp;<field tabindex="0" id="codr_name" name="codr_name" type="Text" contenteditable="true" class="blank input" title="编码员" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="display: inline-block; min-width: 60px; border-bottom: 1px solid rgb(0, 0, 0);">
                            编码员</field>&nbsp;</label>
                        </p>
                    </td>
                </tr>
                <tr style="height: 0.847458cm">
                    <td colspan="12" class="" style="border-color: rgb(0, 0, 0);"><span>
                    </span><span>
                    </span><p style=" font-family: 宋体; font-size: 10.5pt; text-align: Justify;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">病案质量 </label><span>
                        </span><span>
                        </span><field tabindex="0" id="medcas_qlt_code" name="medcas_qlt_code" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0);" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-甲&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-乙&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-丙&quot;}]" value="1" title="1-甲" domain="" code="" contenteditable="true" multi="false" required="false" data-expression="">1-甲</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 1.甲 2.乙 3.丙 质控医师 </label><span>
                        </span><span>
                        </span><field tabindex="0" id="qltctrl_dr_name" name="qltctrl_dr_name" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0);" type="DropdownList" value="" title="质控医师" domain="" code="" contenteditable="true" multi="false" required="false" data-expression="">质控医师</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 质控护士 </label><span>
                        </span><span>
                        </span><field tabindex="0" id="qltctrl_nurs_name" name="qltctrl_nurs_name" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0);" type="DropdownList" value="" title="质控护士" domain="" code="" contenteditable="true" multi="false" required="false" data-expression="">质控护士</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 日期 </label><span>
                        </span><field tabindex="0" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 100px;" id="qltctrl_date" name="qltctrl_date" type="DateTime" format="yyyy年MM月dd日" title="质控日期" domain="" code="" required="false" contenteditable="false">质控日期</field><span>
                    </span></p><span>
                </span></td>
                </tr>

                </tbody>
            </table><br>
                <table style="">

                    <colgroup><col style="width: 67px;"><col style="width: 59px;"><col style="width: 87px;"><col style="width: 78px;"><col style="width: 47px;"><col style="width: 58px;"><col style="width: 54px;"><col style="width: 47px;"><col style="width: 49px;"><col style="width: 69px;"><col style="width: 15px;"><col style="width: 64px;"></colgroup><tbody>

                <tr>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">手术及</label><span>
                        </span></p>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">操作编码</label></p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">手术及</label><span>
                        </span></p>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">操作日期</label></p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">手术及操作名</label><span style=" font-family: 宋体; font-size: 10.5pt;">称</span></p>
                    </td>
                    <td class="" rowspan="1" colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">手术级别</label></p>
                    </td>

                    <td colspan="3" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">手术及操作医师</label></p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">切口愈</label><span style=" font-family: 宋体; font-size: 10.5pt;">合类别</span></p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">麻醉方式</label></p>
                    </td>
                    <td colspan="2" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">麻醉医师</label></p>
                    </td>
                </tr>
                <tr style="height: 26px">
                    <td class=""><span>
                    </span>
                        <p style=""></p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=""></p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=""></p>
                    </td>
                    <td class="" colspan="2"><span>
                    </span>
                        <p style=""></p>
                    </td>

                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">术者</label></p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">Ⅰ助</label></p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">Ⅱ助</label></p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=""></p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=""></p>
                    </td>
                    <td class="" rowspan="1" colspan="2"><span>
                    </span>
                        <p style=""></p>
                    </td>

                </tr>
                <tr style="height: 26px">
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_code-0" name="oprn_oprt_code-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">编码</field>
                        </p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;">
                            <field tabindex="0" id="oprn_oprt_date-0" name="oprn_oprt_date-0" type="DateTime" contenteditable="false" class="blank input" format="yyyy年MM月dd日" title="日期" domain="" code="" required="false" readonly="true">日期</field>&nbsp;<br>
                        </p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_name-0" name="oprn_oprt_name-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="手术名称" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">手术名称</field>
                        </p>
                    </td>
                    <td class="" colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_lv_code-0" name="oprn_lv_code-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-一级手术&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-二级手术&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-三级手术&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-四级手术&quot;}]" value="" title="1-一级手术" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-一级手术</field>
                        </p>
                    </td>

                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oper_name-0" name="oper_name-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="术者" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">术者</field>
                        </p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_1_name-0" name="asit_1_name-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅰ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">Ⅰ助</field>
                        </p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_name2-0" name="asit_name2-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅱ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">Ⅱ助</field>
                        </p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="sinc_heal_lv-0" name="sinc_heal_lv-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;0&quot;},{&quot;text&quot;:&quot;Ⅰ/甲&quot;},{&quot;text&quot;:&quot;Ⅱ/甲&quot;},{&quot;text&quot;:&quot;Ⅲ/甲&quot;},{&quot;text&quot;:&quot;Ⅰ/乙&quot;},{&quot;text&quot;:&quot;Ⅱ/乙&quot;},{&quot;text&quot;:&quot;Ⅲ/乙&quot;},{&quot;text&quot;:&quot;Ⅰ/丙&quot;},{&quot;text&quot;:&quot;Ⅱ/丙&quot;},{&quot;text&quot;:&quot;Ⅲ/丙&quot;},{&quot;text&quot;:&quot;Ⅰ/其他&quot;},{&quot;text&quot;:&quot;Ⅱ/其他&quot;},{&quot;text&quot;:&quot;Ⅲ/其他&quot;}]" value="" title="0" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">0</field>
                        </p>
                    </td>
                    <td class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_mtd_name-0" name="anst_mtd_name-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉方式" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">麻醉方式</field>
                        </p>
                    </td>
                    <td colspan="2" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_dr_name-0" name="anst_dr_name-0" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉医师" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">麻醉医师</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_code-1" name="oprn_oprt_code-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">编码</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;">
                            <field tabindex="0" id="oprn_oprt_date-1" name="oprn_oprt_date-1" type="DateTime" contenteditable="false" class="blank input" format="yyyy年MM月dd日" title="日期" domain="" code="" required="false" readonly="true">日期</field>&nbsp;<br>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_name-1" name="oprn_oprt_name-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="手术名称" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                手术名称</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_lv_code-1" name="oprn_lv_code-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-一级手术&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-二级手术&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-三级手术&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-四级手术&quot;}]" value="" title="1-一级手术" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-一级手术</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oper_name-1" name="oper_name-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="术者" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                术者</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_1_name-1" name="asit_1_name-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅰ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅰ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_name2-1" name="asit_name2-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅱ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅱ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="sinc_heal_lv-1" name="sinc_heal_lv-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;0&quot;},{&quot;text&quot;:&quot;Ⅰ/甲&quot;},{&quot;text&quot;:&quot;Ⅱ/甲&quot;},{&quot;text&quot;:&quot;Ⅲ/甲&quot;},{&quot;text&quot;:&quot;Ⅰ/乙&quot;},{&quot;text&quot;:&quot;Ⅱ/乙&quot;},{&quot;text&quot;:&quot;Ⅲ/乙&quot;},{&quot;text&quot;:&quot;Ⅰ/丙&quot;},{&quot;text&quot;:&quot;Ⅱ/丙&quot;},{&quot;text&quot;:&quot;Ⅲ/丙&quot;},{&quot;text&quot;:&quot;Ⅰ/其他&quot;},{&quot;text&quot;:&quot;Ⅱ/其他&quot;},{&quot;text&quot;:&quot;Ⅲ/其他&quot;}]" value="" title="0" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">0</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_mtd_name-1" name="anst_mtd_name-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉方式" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉方式</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_dr_name-1" name="anst_dr_name-1" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉医师" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉医师</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_code-2" name="oprn_oprt_code-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">编码</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;">
                            <field tabindex="0" id="oprn_oprt_date-2" name="oprn_oprt_date-2" type="DateTime" contenteditable="false" class="blank input" format="yyyy年MM月dd日" title="日期" domain="" code="" required="false" readonly="true">日期</field>&nbsp;<br>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_name-2" name="oprn_oprt_name-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="手术名称" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                手术名称</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_lv_code-2" name="oprn_lv_code-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-一级手术&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-二级手术&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-三级手术&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-四级手术&quot;}]" value="" title="1-一级手术" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-一级手术</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oper_name-2" name="oper_name-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="术者" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                术者</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_1_name-2" name="asit_1_name-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅰ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅰ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_name2-2" name="asit_name2-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅱ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅱ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="sinc_heal_lv-2" name="sinc_heal_lv-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;0&quot;},{&quot;text&quot;:&quot;Ⅰ/甲&quot;},{&quot;text&quot;:&quot;Ⅱ/甲&quot;},{&quot;text&quot;:&quot;Ⅲ/甲&quot;},{&quot;text&quot;:&quot;Ⅰ/乙&quot;},{&quot;text&quot;:&quot;Ⅱ/乙&quot;},{&quot;text&quot;:&quot;Ⅲ/乙&quot;},{&quot;text&quot;:&quot;Ⅰ/丙&quot;},{&quot;text&quot;:&quot;Ⅱ/丙&quot;},{&quot;text&quot;:&quot;Ⅲ/丙&quot;},{&quot;text&quot;:&quot;Ⅰ/其他&quot;},{&quot;text&quot;:&quot;Ⅱ/其他&quot;},{&quot;text&quot;:&quot;Ⅲ/其他&quot;}]" value="" title="0" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">0</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_mtd_name-2" name="anst_mtd_name-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉方式" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉方式</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_dr_name-2" name="anst_dr_name-2" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉医师" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉医师</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_code-3" name="oprn_oprt_code-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">编码</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;">
                            <field tabindex="0" id="oprn_oprt_date-3" name="oprn_oprt_date-3" type="DateTime" contenteditable="false" class="blank input" format="yyyy年MM月dd日" title="日期" domain="" code="" required="false" readonly="true">日期</field>&nbsp;<br>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_name-3" name="oprn_oprt_name-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="手术名称" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                手术名称</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_lv_code-3" name="oprn_lv_code-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-一级手术&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-二级手术&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-三级手术&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-四级手术&quot;}]" value="" title="1-一级手术" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-一级手术</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oper_name-3" name="oper_name-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="术者" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                术者</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_1_name-3" name="asit_1_name-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅰ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅰ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_name2-3" name="asit_name2-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅱ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅱ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="sinc_heal_lv-3" name="sinc_heal_lv-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;0&quot;},{&quot;text&quot;:&quot;Ⅰ/甲&quot;},{&quot;text&quot;:&quot;Ⅱ/甲&quot;},{&quot;text&quot;:&quot;Ⅲ/甲&quot;},{&quot;text&quot;:&quot;Ⅰ/乙&quot;},{&quot;text&quot;:&quot;Ⅱ/乙&quot;},{&quot;text&quot;:&quot;Ⅲ/乙&quot;},{&quot;text&quot;:&quot;Ⅰ/丙&quot;},{&quot;text&quot;:&quot;Ⅱ/丙&quot;},{&quot;text&quot;:&quot;Ⅲ/丙&quot;},{&quot;text&quot;:&quot;Ⅰ/其他&quot;},{&quot;text&quot;:&quot;Ⅱ/其他&quot;},{&quot;text&quot;:&quot;Ⅲ/其他&quot;}]" value="" title="0" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">0</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_mtd_name-3" name="anst_mtd_name-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉方式" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉方式</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_dr_name-3" name="anst_dr_name-3" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉医师" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉医师</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_code-4" name="oprn_oprt_code-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">编码</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;">
                            <field tabindex="0" id="oprn_oprt_date-4" name="oprn_oprt_date-4" type="DateTime" contenteditable="false" class="blank input" format="yyyy年MM月dd日" title="日期" domain="" code="" required="false" readonly="true">日期</field>&nbsp;<br>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_name-4" name="oprn_oprt_name-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="手术名称" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                手术名称</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_lv_code-4" name="oprn_lv_code-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-一级手术&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-二级手术&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-三级手术&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-四级手术&quot;}]" value="" title="1-一级手术" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-一级手术</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oper_name-4" name="oper_name-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="术者" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                术者</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_1_name-4" name="asit_1_name-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅰ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅰ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_name2-4" name="asit_name2-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅱ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅱ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="sinc_heal_lv-4" name="sinc_heal_lv-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;0&quot;},{&quot;text&quot;:&quot;Ⅰ/甲&quot;},{&quot;text&quot;:&quot;Ⅱ/甲&quot;},{&quot;text&quot;:&quot;Ⅲ/甲&quot;},{&quot;text&quot;:&quot;Ⅰ/乙&quot;},{&quot;text&quot;:&quot;Ⅱ/乙&quot;},{&quot;text&quot;:&quot;Ⅲ/乙&quot;},{&quot;text&quot;:&quot;Ⅰ/丙&quot;},{&quot;text&quot;:&quot;Ⅱ/丙&quot;},{&quot;text&quot;:&quot;Ⅲ/丙&quot;},{&quot;text&quot;:&quot;Ⅰ/其他&quot;},{&quot;text&quot;:&quot;Ⅱ/其他&quot;},{&quot;text&quot;:&quot;Ⅲ/其他&quot;}]" value="" title="0" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">0</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_mtd_name-4" name="anst_mtd_name-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉方式" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉方式</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_dr_name-4" name="anst_dr_name-4" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉医师" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉医师</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_code-5" name="oprn_oprt_code-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">编码</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;">
                            <field tabindex="0" id="oprn_oprt_date-5" name="oprn_oprt_date-5" type="DateTime" contenteditable="false" class="blank input" format="yyyy年MM月dd日" title="日期" domain="" code="" required="false" readonly="true">日期</field>&nbsp;<br>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_name-5" name="oprn_oprt_name-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="手术名称" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                手术名称</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_lv_code-5" name="oprn_lv_code-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-一级手术&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-二级手术&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-三级手术&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-四级手术&quot;}]" value="" title="1-一级手术" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-一级手术</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oper_name-5" name="oper_name-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="术者" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                术者</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_1_name-5" name="asit_1_name-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅰ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅰ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_name2-5" name="asit_name2-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅱ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅱ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="sinc_heal_lv-5" name="sinc_heal_lv-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;0&quot;},{&quot;text&quot;:&quot;Ⅰ/甲&quot;},{&quot;text&quot;:&quot;Ⅱ/甲&quot;},{&quot;text&quot;:&quot;Ⅲ/甲&quot;},{&quot;text&quot;:&quot;Ⅰ/乙&quot;},{&quot;text&quot;:&quot;Ⅱ/乙&quot;},{&quot;text&quot;:&quot;Ⅲ/乙&quot;},{&quot;text&quot;:&quot;Ⅰ/丙&quot;},{&quot;text&quot;:&quot;Ⅱ/丙&quot;},{&quot;text&quot;:&quot;Ⅲ/丙&quot;},{&quot;text&quot;:&quot;Ⅰ/其他&quot;},{&quot;text&quot;:&quot;Ⅱ/其他&quot;},{&quot;text&quot;:&quot;Ⅲ/其他&quot;}]" value="" title="0" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">0</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_mtd_name-5" name="anst_mtd_name-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉方式" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉方式</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_dr_name-5" name="anst_dr_name-5" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉医师" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉医师</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_code-6" name="oprn_oprt_code-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">编码</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;">
                            <field tabindex="0" id="oprn_oprt_date-6" name="oprn_oprt_date-6" type="DateTime" contenteditable="false" class="blank input" format="yyyy年MM月dd日" title="日期" domain="" code="" required="false" readonly="true">日期</field>&nbsp;<br>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_name-6" name="oprn_oprt_name-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="手术名称" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                手术名称</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_lv_code-6" name="oprn_lv_code-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-一级手术&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-二级手术&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-三级手术&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-四级手术&quot;}]" value="" title="1-一级手术" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-一级手术</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oper_name-6" name="oper_name-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="术者" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                术者</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_1_name-6" name="asit_1_name-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅰ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅰ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_name2-6" name="asit_name2-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅱ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅱ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="sinc_heal_lv-6" name="sinc_heal_lv-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;0&quot;},{&quot;text&quot;:&quot;Ⅰ/甲&quot;},{&quot;text&quot;:&quot;Ⅱ/甲&quot;},{&quot;text&quot;:&quot;Ⅲ/甲&quot;},{&quot;text&quot;:&quot;Ⅰ/乙&quot;},{&quot;text&quot;:&quot;Ⅱ/乙&quot;},{&quot;text&quot;:&quot;Ⅲ/乙&quot;},{&quot;text&quot;:&quot;Ⅰ/丙&quot;},{&quot;text&quot;:&quot;Ⅱ/丙&quot;},{&quot;text&quot;:&quot;Ⅲ/丙&quot;},{&quot;text&quot;:&quot;Ⅰ/其他&quot;},{&quot;text&quot;:&quot;Ⅱ/其他&quot;},{&quot;text&quot;:&quot;Ⅲ/其他&quot;}]" value="" title="0" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">0</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_mtd_name-6" name="anst_mtd_name-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉方式" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉方式</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_dr_name-6" name="anst_dr_name-6" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉医师" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉医师</field>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_code-7" name="oprn_oprt_code-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" contenteditable="false" type="Text" title="编码" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">编码</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;">
                            <field tabindex="0" id="oprn_oprt_date-7" name="oprn_oprt_date-7" type="DateTime" contenteditable="false" class="blank input" format="yyyy年MM月dd日" title="日期" domain="" code="" required="false" readonly="true">日期</field>&nbsp;<br>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_oprt_name-7" name="oprn_oprt_name-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="手术名称" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                手术名称</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oprn_lv_code-7" name="oprn_lv_code-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-一级手术&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-二级手术&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-三级手术&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-四级手术&quot;}]" value="" title="1-一级手术" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-一级手术</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="oper_name-7" name="oper_name-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="术者" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                术者</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_1_name-7" name="asit_1_name-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅰ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅰ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="asit_name2-7" name="asit_name2-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="Ⅱ助" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                Ⅱ助</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="sinc_heal_lv-7" name="sinc_heal_lv-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;" type="DropdownList" data-list="[{&quot;text&quot;:&quot;0&quot;},{&quot;text&quot;:&quot;Ⅰ/甲&quot;},{&quot;text&quot;:&quot;Ⅱ/甲&quot;},{&quot;text&quot;:&quot;Ⅲ/甲&quot;},{&quot;text&quot;:&quot;Ⅰ/乙&quot;},{&quot;text&quot;:&quot;Ⅱ/乙&quot;},{&quot;text&quot;:&quot;Ⅲ/乙&quot;},{&quot;text&quot;:&quot;Ⅰ/丙&quot;},{&quot;text&quot;:&quot;Ⅱ/丙&quot;},{&quot;text&quot;:&quot;Ⅲ/丙&quot;},{&quot;text&quot;:&quot;Ⅰ/其他&quot;},{&quot;text&quot;:&quot;Ⅱ/其他&quot;},{&quot;text&quot;:&quot;Ⅲ/其他&quot;}]" value="" title="0" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">0</field>
                        </p>
                    </td>
                    <td colspan="1"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_mtd_name-7" name="anst_mtd_name-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉方式" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉方式</field>
                        </p>
                    </td>
                    <td colspan="2"><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Center;"><span>
                        </span>
                            <field tabindex="0" id="anst_dr_name-7" name="anst_dr_name-7" class="blank" style=" font-family: 宋体; font-size: 10.5pt;" type="DropdownList" value="" title="麻醉医师" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">
                                麻醉医师</field>
                        </p>
                    </td>
                </tr>
                <tr style="height: 0.881356cm">
                    <td colspan="12" class=""><span style="font-size: xxx-large;">
                    </span>
                        <p style="font-family: 宋体;"><label style="font-size: 10.5pt; font-weight: bold;">切口类别：</label><span style="font-size: 10.5pt;">
                        </span><label style="font-size: 10.5pt;">0.0类切口 1.I类切口 2.Ⅱ类切口 3.III类切口</label>
                        </p>
                    </td>
                </tr>
                <tr style="height: 1.23729cm">
                    <td colspan="12" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">离院方式 </label><span>
                        </span>
                            <field tabindex="0" id="dscg_way" name="dscg_way" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0);" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-医嘱离院&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-医嘱转院&quot;},{&quot;value&quot;:&quot;3&quot;,&quot;text&quot;:&quot;3-医嘱转社区卫生服务机构/乡镇卫生院&quot;},{&quot;value&quot;:&quot;4&quot;,&quot;text&quot;:&quot;4-非医嘱离院&quot;},{&quot;value&quot;:&quot;5&quot;,&quot;text&quot;:&quot;5-死亡&quot;},{&quot;value&quot;:&quot;9&quot;,&quot;text&quot;:&quot;9-其他&quot;}]" value="1" title="1-医嘱离院" domain="" code="" contenteditable="true" multi="false" required="false" data-expression="">1-医嘱离院</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 1.医嘱离院 2.医嘱转院，拟接收机构名称：</label><span>
                        </span>
                            <field tabindex="0" id="acp_medins_code" name="acp_medins_code" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 200px;" contenteditable="true" type="Text" title="拟接收机构名称" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">拟接收机构名称</field><span>
                        </span><span>&nbsp;</span>
                        </p>
                        <p style=" font-family: 宋体; font-size: 10.5pt;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">3.医嘱转社区卫生服务机构/乡镇卫生院，拟接收机构名称：</label>
                            <field tabindex="0" id="acp_medins_code" name="acp_medins_code" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 111px;" contenteditable="true" type="Text" title="拟接收机构名称" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">拟接收机构名称</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">4.非医嘱转院 5.死亡 9.其他</label>
                        </p>
                    </td>
                </tr>
                <tr style="height: 1.00847cm">
                    <td colspan="12" class=""><span>
                    </span>
                        <p style=" font-family: 宋体; font-size: 10.5pt; text-align: Justify;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">是否有出院31天内再住院计划 </label><span>
                        </span>
                            <field tabindex="0" id="dscg_31days_rinp_flag" name="dscg_31days_rinp_flag" class="" style="font-family: 宋体; font-size: 10.5pt; text-align: center; border-bottom: 1px solid rgb(0, 0, 0);" type="DropdownList" data-list="[{&quot;value&quot;:&quot;1&quot;,&quot;text&quot;:&quot;1-无&quot;},{&quot;value&quot;:&quot;2&quot;,&quot;text&quot;:&quot;2-有&quot;}]" value="1" title="" domain="" code="" contenteditable="false" multi="false" required="false" data-expression="">1-无</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;"> 1.无 2.有 目的：</label><span>
                        </span>
                            <field tabindex="0" id="dscg_31days_rinp_pup" name="dscg_31days_rinp_pup" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 200px;" contenteditable="true" type="Text" title="目的" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">目的</field>
                        </p>
                    </td>
                </tr>
                <tr style="height: 1.02542cm">
                    <td colspan="12" class=""><span>
                    </span>
                        <p style="font-family: 宋体; font-size: 10.5pt; text-align: justify; text-indent: 0px;"><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">颅脑损伤患者昏迷时间：入院前 </label>
                            <field tabindex="0" id="brn_damg_bfadm_coma_dura" name="brn_damg_bfadm_coma_dura" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true" type="Text" title="天数" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">天数</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">天 </label><span>
                        </span>
                            <field tabindex="0" id="brn_damg_bfadm_coma_dura" name="brn_damg_bfadm_coma_dura" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-style: none none solid; border-bottom-width: 1px; border-bottom-color: rgb(0, 0, 0);" contenteditable="true" type="Text" title="小时" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">小时</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">小时</label><span>
                        </span>
                            <field tabindex="0" id="brn_damg_bfadm_coma_dura" name="brn_damg_bfadm_coma_dura" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true" type="Text" title="分钟" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">分钟</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">分钟   入院后 </label>
                            <field tabindex="0" id="brn_damg_afadm_coma_dura" name="brn_damg_afadm_coma_dura" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true" type="Text" title="天数" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">天数</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">天 </label><span>
                        </span>
                            <field tabindex="0" id="brn_damg_afadm_coma_dura" name="brn_damg_afadm_coma_dura" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true" type="Text" title="小时" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">小时</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">小时 </label>
                            <field tabindex="0" id="brn_damg_afadm_coma_dura" name="brn_damg_afadm_coma_dura" class="blank" style="font-family: 宋体; font-size: 10.5pt; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="true" type="Text" title="分钟" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">分钟</field><span>
                        </span><label style=" font-family: 宋体; font-size: 10.5pt;">分钟</label>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td colspan="12" class=""><span style="font-size: xxx-large;">
                    </span>
                        <p style="font-family: 宋体;"><label style="font-size: 10.5pt; text-align: justify; color: rgb(32, 31, 53); font-weight: bold;">住院费用（元）：总费用</label><span style="font-size: 10.5pt; text-align: justify;">
                        </span><label style="font-size: 10.5pt; text-align: justify; color: rgb(32, 31, 53);"> </label><span style="font-size: 10.5pt; text-align: justify;">
                        </span>
                            <field tabindex="0" id="medfee_sumamt" name="medfee_sumamt" class="blank" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false">¥</field><span style="font-size: 10.5pt; text-align: justify;">
                        </span><label style="font-size: 10.5pt; text-align: justify; color: rgb(32, 31, 53);"> </label><span style="font-size: 10.5pt; text-align: justify;">
                        </span><label style="font-size: 10.5pt; text-align: justify; color: rgb(32, 31, 53);">（自付金额：</label><span style="font-size: 10.5pt; text-align: justify;">
                        </span><label style="font-size: 10.5pt; text-align: justify; color: rgb(32, 31, 53);"> </label><span style="font-size: 10.5pt; text-align: justify;">
                        </span>
                            <field tabindex="0" id="selfpay_amt" name="selfpay_amt" class="blank" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false">¥</field><span style="font-size: 10.5pt; text-align: justify;">
                        </span><label style="font-size: 10.5pt; text-align: justify; color: rgb(32, 31, 53);"> </label><span style="font-size: 10.5pt; text-align: justify;">
                        </span><label style="font-size: 10.5pt; text-align: justify; color: rgb(32, 31, 53);">）</label>
                        </p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;">1.综合医疗服务类：</label><label style="font-family: 宋体; color: rgb(32, 31, 53);">(1)一般医疗服务费：</label>
                            <field tabindex="0" id="ordn_med_servfee" name="ordn_med_servfee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field><label style="font-family: 宋体; color: rgb(32, 31, 53);">((2)一般治疗操作费：</label>
                            <field tabindex="0" id="ordn_trt_oprt_fee" name="ordn_trt_oprt_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(3)护理费：</label>
                            <field tabindex="0" id="nurs_fee" name="nurs_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field><label style="font-family: 宋体; color: rgb(32, 31, 53);">(4)其他费用：</label>
                            <field tabindex="0" id="com_med_serv_oth_fee" name="com_med_serv_oth_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                        </span></p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;">2.诊断类：</label><label style="font-family: 宋体; color: rgb(32, 31, 53);">(5)病理诊断费：</label>
                            <field tabindex="0" id="palg_diag_fee" name="palg_diag_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(6)实验室诊断费：</label>
                            <field tabindex="0" id="lab_diag_fee" name="lab_diag_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(7)影像学诊断费：</label>
                            <field tabindex="0" id="rdhy_diag_fee" name="rdhy_diag_fee" class="blank" style="display: inline-block; min-width: 50px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(8)临床诊断项目费：</label>
                            <field tabindex="0" id="clnc_dise_fee" name="clnc_dise_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                        </span></p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;">3.治疗类：</label>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(9)非手术治疗项目费：</label>
                            <field tabindex="0" id="nsrgtrt_item_fee" name="nsrgtrt_item_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">（临床物理治疗费：</label>
                            <field tabindex="0" id="clnc_phys_trt_fee" name="clnc_phys_trt_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">）</label>
                        </span></p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53);">          (10)手术治疗费：</label>
                            <field tabindex="0" id="rgtrt_trt_fee" name="rgtrt_trt_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">（麻醉费：</label>
                            <field tabindex="0" id="anst_fee" name="anst_fee" class="blank" style="display: inline-block; min-width: 50px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">手术费：</label>
                            <field tabindex="0" id="rgtrt_fee" name="rgtrt_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">）</label>
                        </span></p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;">4.康复类：</label>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(11)康复费：</label>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);"> </label>
                            <field tabindex="0" id="rhab_fee" name="rhab_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">  </label>
                        </span></p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;">5.中医类：</label>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(12)中医治疗费：</label>
                            <field tabindex="0" id="tcm_trt_fee" name="tcm_trt_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);"> </label>
                        </span></p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;">6.西药类：</label>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(13)西药费：</label>
                            <field tabindex="0" id="wm_fee" name="wm_fee" class="blank" style="display: inline-block; min-width: 50px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">（抗菌药物费用：</label>
                            <field tabindex="0" id="abtl_medn_fee" name="abtl_medn_fee" class="blank" style="display: inline-block; min-width: 50px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">）</label>
                        </span></p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;">7.中药类：</label>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(14)中成药费：</label>
                            <field tabindex="0" id="tcmpat_fee" name="tcmpat_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);"> (15)中草药费：</label>
                            <field tabindex="0" id="tcmherb_fee" name="tcmherb_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                        </span></p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;">8.血液和血液制品类：</label><label style="font-family: 宋体; color: rgb(32, 31, 53);">(16)血费：</label>
                            <field tabindex="0" id="blo_fee" name="blo_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(17)白蛋白类制品费：</label>
                            <field tabindex="0" id="albu_fee" name="albu_fee" class="blank" style="display: inline-block; min-width: 50px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(18)球蛋白类制品费：</label>
                            <field tabindex="0" id="glon_fee" name="glon_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                        </span></p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53);">                    (19)凝血因子类制品费：</label>
                            <field tabindex="0" id="clotfac_fee" name="clotfac_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);"> (20)细胞因子类制品费：</label>
                            <field tabindex="0" id="cyki_fee" name="cyki_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="true" type="Text" title="¥" domain="" multiline="false" required="false">¥</field>
                        </span></p>
                        <p style="font-family: 宋体; text-align: justify;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;">9.耗材类：</label>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">(21)检查用一次性医用材料费：</label>
                            <field tabindex="0" id="exam_dspo_matl_fee" name="exam_dspo_matl_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">（22）治疗用一次性医用材料费：</label>
                            <field tabindex="0" id="trt_dspo_matl_fee" name="trt_dspo_matl_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="true" type="Text" title="¥" domain="" multiline="false" required="false">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);"> </label>
                        </span></p>
                        <p style="font-family: 宋体;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53);">          (23)手术用一次性医用材料费：</label>
                            <field tabindex="0" id="oprn_dspo_matl_fee" name="oprn_dspo_matl_fee" class="blank" style="display: inline-block; min-width: 50px; border-bottom: 1px solid rgb(0, 0, 0);" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);"> </label>
                        </span></p>
                        <p style="font-family: 宋体;">
                        <span style="font-size: 10.5pt;"><label style="font-family: 宋体; color: rgb(32, 31, 53); font-weight: bold;">10.其他类：</label>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);">（24）其他费：</label>
                            <field tabindex="0" id="oth_fee" name="oth_fee" class="blank" style="border-bottom: 1px solid rgb(0, 0, 0); display: inline-block; min-width: 50px;" contenteditable="false" type="Text" title="¥" domain="" code="" multiline="false" required="false" format="" inputmode="" data-expression="">¥</field>
                            <label style="font-family: 宋体; color: rgb(32, 31, 53);"> <br></label>
                        </span></p>
                    </td>
                </tr>
                </tbody>
                </table></p><p><span>
		</span><label style=" font-family: 宋体; font-size: 10.5pt;">说明：（一）医疗付费方式  1.城镇职工基本医疗保险  2.城镇居民基本医疗保险  3.新型农村合作医疗  4.贫困       求助  5.商业医疗保险  6.全公费  7.全自费  8.其他社区保险  9.其他</label><span>
	</span></p><p style=""><span>
		</span><label style=" font-family: 宋体; font-size: 10.5pt;">      （二）凡是由医院信息系统提供住院费用清单的，住院病案首页中不可以填写“住院费用”。</label><span>
</span></p><p style=""><label style="font-family: 宋体; font-size: 10.5pt;"><img type="sign" style="width: 100px; height: 50px;" draggable="false" src="data:image/png;base64,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" signed="true"><br></label></p></div>

            <div id="_footer" style="outline: none; position: relative; min-height: 1.54cm; padding-left: 1.54cm; padding-right: 1.54cm; padding-bottom: 0.77cm;" contenteditable="false" class="">
                <p style=" font-family: 宋体; font-size: 12pt; text-align: Center;">
                    <label style=" font-family: 宋体; font-size: 9pt;">第</label>
                    <field page="pageNum" style="font-size:10pt">1</field>
                    <label style=" font-family: 宋体; font-size: 9pt;">页</label>
                </p></div>

























































































































































































        </div>
    </div>
</body>
</html>
