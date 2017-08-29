<template>
	<div>
		<s-title>人物升级经验消耗</s-title>
		<s-input v-model="from" label="初始等级:" :val="from"></s-input>
		<s-input v-model="to" label="目标等级:" :val="to"></s-input>

		<s-button label="查询" @click.native="getExpResult"></s-button>

		<s-result v-model="expResult" label="消耗经验:">{{expResult}}</s-result>
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
                expResult: ''
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
            getExpResult: function () {
                let from = parseInt(this.from);
                let to = parseInt(this.to);
                if (!isNaN(from) && !isNaN(to)) {
                    let scope = this;
                    axios.get(baseUrl + '/person/upgradeExp', {
                        params: {
                            from: from,
                            to: to
                        }
                    }).then(function (response) {
                        let data = response.data;
                        if (data.status == '0') {
                            scope.expResult = data.data.exp;
                        } else {
                            scope.expResult = data.message;
                        }
                    });
                }
            }
        }
    }
</script>

<style>
</style>