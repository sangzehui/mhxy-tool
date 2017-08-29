<template>
	<button class="s-btn">{{label}}</button>
</template>

<script>
    export default {
        name: 's-button',
	    props: ['label'],
	    methods: {
	    }
    }
</script>

<style>
	.s-btn {
		padding: 4px 10px;
	}
</style>