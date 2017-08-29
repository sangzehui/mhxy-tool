<template>
	<div class="title">
		<slot></slot>
	</div>
</template>

<script>
    export default {
        name: 's-title',
	    props: [],
	    methods: {
	    }
    }
</script>

<style>
	.title {
		text-align: center;
		font-size: 18px;
		border: 1px solid #555;
		border-left: none;
		border-right: none;
		background: #ddd;
		padding: 10px 0;
		margin: 0 0 10px 0;
	}
</style>