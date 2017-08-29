<template>
	<div>
		<s-title>人物修炼消耗</s-title>
		<s-input v-model="from" label="初始等级:" :val="from"></s-input>
		<s-input v-model="to" label="目标等级:" :val="to"></s-input>

		<s-button label="查询" @click.native="getResult"></s-button>

		<s-result v-model="moneyResult1" label="金钱(物理/法术/猎术):">{{moneyResult1}}</s-result>
		<s-result v-model="moneyResult2" label="金钱(防御/修炼):">{{moneyResult2}}</s-result>
		<s-result v-model="levelResult" label="需要等级:">{{levelResult}}</s-result>
		<s-result v-model="contributionResult" label="需要历史帮贡:">{{contributionResult}}</s-result>
		<s-result v-model="materialResult" label="消耗资材:">{{materialResult}}</s-result>
		<s-result v-model="expResult" label="修炼经验:">{{expResult}}</s-result>
	</div>
</template>

<script>
    import Input from '../../component/SangInput.vue'
    import Button from '../../component/SangButton.vue'
    import Title from '../../component/SangTitle.vue'
    import Result from '../../component/SangResult.vue'
    import axios from 'axios'

    export default {
        name: 'person-page',
        data: function () {
            return {
                from: '',
                to: '',
                moneyResult1: '',
                moneyResult2: '',
                levelResult: '',
                contributionResult: '',
                materialResult: '',
                expResult: '',
            }
        },
        components: {
            's-input': Input,
            's-button': Button,
            's-title': Title,
            's-result': Result,
        },
        watch: {},
        computed: {},
        methods: {
            getResult: function () {
                let from = parseInt(this.from);
                let to = parseInt(this.to);
                if (!isNaN(from) && !isNaN(to)) {
                    let scope = this;
                    axios.get(baseUrl + '/person/upgradePractice', {
                        params: {
                            from: from,
                            to: to
                        }
                    }).then(function (response) {
                        let data = response.data;
                        if (data.status == '0') {
                            scope.moneyResult1 = data.data.money1;
                            scope.moneyResult2 = data.data.money2;
                            scope.levelResult = data.data.level;
                            scope.contributionResult = data.data.contribution;
                            scope.materialResult = data.data.material;
                            scope.expResult = data.data.exp;
                        } else {
                            scope.moneyResult1 = data.message;
                        }
                    });
                }
            }
        }
    }
</script>

<style>
</style>