<template>
	<div>
		<s-title>盘丝固定伤害计算</s-title>
		<s-input v-model="jineng" :val="jineng" label="天罗地网技能:"></s-input>
		<s-input v-model="dengji" :val="dengji" label="自身人物等级:"></s-input>
		<s-input v-model="zongshang" :val="zongshang" label="面板总伤:"></s-input>
		<s-input v-model="faxiu" :val="faxiu" label="自身法修等级:"></s-input>
		<s-input v-model="fakang" :val="fakang" label="怪物法抗等级:"></s-input>
		<s-input v-model="lingshi" :val="lingshi" label="固伤灵饰加成:"></s-input>
		<s-input v-model="fushi" :val="fushi" label="固伤符石加成:"></s-input>
		<s-input v-model="linshifu" :val="linshifu" label="神木林临时符:"></s-input>
		<form-item label="奇经八脉选择:">
			<select v-model="jingmai">
				<option v-for="item in jingmaiItems" :value="item.value">{{item.text}}</option>
			</select>
		</form-item>
		<s-input v-model="shanghai" :val="shanghai" label="武器伤害(含灵饰+头):"></s-input>
		<form-item label="孔装第一件:">
			<select v-model="zuhe1">
				<option v-for="item in zuheItems" :value="item.value">{{item.text}}</option>
			</select>
		</form-item>
		<form-item label="孔装第二件:">
			<select v-model="zuhe2">
				<option v-for="item in zuheItems" :value="item.value">{{item.text}}</option>
			</select>
		</form-item>
		<form-item label="阵法选择:">
			<select v-model="zhenfa">
				<option v-for="item in zhenfaItems" :value="item.value">{{item.text}}</option>
			</select>
		</form-item>

		<s-button label="查询" @click.native="getResult"></s-button>
		<s-button label="109属性" @click.native="set109"></s-button>
		<s-button label="129属性" @click.native="set129"></s-button>
		<s-button label="175属性" @click.native="set175"></s-button>

		<s-result v-model="result" label="非点选伤害结果:">{{result}}</s-result>
		<s-result v-model="result2" label="点选伤害结果:">{{result2}}</s-result>
	</div>
</template>

<script>
    import FormItem from '../../component/FormItem.vue'
    import Input from '../../component/SangInput.vue'
    import Button from '../../component/SangButton.vue'
    import Title from '../../component/SangTitle.vue'
    import Result from '../../component/SangResult.vue'
    import axios from 'axios'
    import {fixParam} from '../util/ParamUtil'

    export default {
        name: 'fixed-page',
        data: function () {
            return {
                jineng: '',
                dengji: '',
                minjie: '',
                faxiu: '',
                fakang: '',
                geshu: '',
                lingshi: '',
                fushi: '',
                zongshang: '',
                linshifu: '',
                jingmai: '0',
                jingmaiItems: [
                    {text: '无', value: '0'},
                    {text: '粘附', value: '4'},
                ],
                shanghai: '',
                zuhe1: '0',
                zuhe2: '0',
                zuheItems: [
                    {text: '无', value: '0'},
                    {text: '双孔', value: '37'},
                    {text: '三孔', value: '50'},
                    {text: '四孔', value: '75'},
                ],
                zhenfa: '0',
                zhenfaItems: [
                    {text: '无', value: '0'},
                    {text: '天阵', value: '15'},
                    {text: '雷阵', value: '20'},
                ],
                result: '',
                result2: '',
            }
        },
        components: {
            'form-item': FormItem,
            's-input': Input,
            's-button': Button,
            's-title': Title,
            's-result': Result,
        },
        watch: {},
        computed: {},
        methods: {
            getResult: function () {
				let scope = this;
                let param = {
                    jineng: this.jineng,
					dengji: this.dengji,
					faxiu: this.faxiu,
					fakang: this.fakang,
					lingshi: this.lingshi,
					fushi: this.fushi,
					linshifu: this.linshifu,
					jingmai: this.jingmai,
					shanghai: this.shanghai,
					zuhe1: this.zuhe1,
					zuhe2: this.zuhe2,
					zhenfa: this.zhenfa,
                    zongshang: this.zongshang,
                };
                fixParam(param, 0);
				axios.get(baseUrl + '/fixedDamage/ps', {
				    params: param
				}).then(function (response) {
					let data = response.data;
					if (data.status == '0') {
						scope.result = data.data.damage;
                        scope.result2 = data.data.damage2;
					} else {
						scope.result = data.message;
					}
				});
            },
            set109: function () {
                this.jineng = 119;
                this.dengji = 109;
                this.faxiu = 17;
                this.fakang = 0;
                this.lingshi = 120;
                this.fushi = 0;
                this.linshifu = 0;
                this.jingmai = 4;
                this.shanghai = 500;
                this.zuhe1 = 75;
                this.zuhe2 = 75;
                this.zhenfa = 15;
                this.zongshang = 1600;
            },
            set129: function () {
                this.jineng = 150;
                this.dengji = 129;
                this.faxiu = 20;
                this.fakang = 0;
                this.lingshi = 120;
                this.fushi = 0;
                this.linshifu = 0;
                this.jingmai = 4;
                this.shanghai = 550;
                this.zuhe1 = 75;
                this.zuhe2 = 75;
                this.zhenfa = 15;
                this.zongshang = 1800;
            },
            set175: function () {
                this.dengji = 175;
                this.jineng = 180;
                this.faxiu = 25;
                this.fakang = 0;
                this.lingshi = 150;
                this.fushi = 0;
                this.linshifu = 0;
                this.jingmai = 4;
                this.shanghai = 700;
                this.zuhe1 = 75;
                this.zuhe2 = 75;
                this.zhenfa = 15;
                this.zongshang = 2600;
            },
        }
    }
</script>

<style>
</style>