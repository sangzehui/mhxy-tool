<template>
	<form-item :label="label">
		<div class="result">
			<slot></slot>
		</div>
	</form-item>
</template>

<script>
	import FormItem from './FormItem.vue'

    export default {
        name: 's-input',
        props: ['label'],
	    components: {
            'form-item': FormItem,
	    },
        methods: {
        }
    }
</script>

<style>
</style>