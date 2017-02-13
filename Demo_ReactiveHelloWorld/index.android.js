/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    Image
} from 'react-native';

export default class Demo_ReactiveHelloWorld extends Component {
    render() {
        return (
            <View
                style={ {flexDirection:'column',alignItems:'stretch',backgroundColor:'#ffffff'}}>

                <View style={myStyles.banner}>
                    <Image style={myStyles.bannerImage}
                           source={{uri:'http://p1.meituan.net/kuailv/95302db8387eb528074409ddab1beebb68823.jpg'}}/>
                </View>

                <View
                    style={myStyles.salesLayout }>
                    <View
                        style={ {flexDirection:'row',justifyContent:'space-between',paddingLeft:10,paddingRight:10,paddingTop:10} }>
                        <Text style={ myStyles.subTitleText }>天天优惠</Text>
                        <Text style={ myStyles.subTitleText }>低至七折</Text>
                    </View>
                    <View style={ myStyles.divider }></View>
                    <View
                        style={ {flexDirection:'row',alignItems:'stretch',justifyContent:'space-around',paddingTop:10,paddingBottom:10} }>
                        <View style={ myStyles.salesView }>
                            <Image style={myStyles.salesImage}
                                   source={ {uri:'http://p0.meituan.net/sjstpic/ec4c21447fa519b966302a8594e8990f121471.jpg'} }/>
                        </View>
                        <View style={ myStyles.salesView }>
                            <Image style={myStyles.salesImage}
                                   source={ {uri:'http://p1.meituan.net/sjstpic/8cb25d2ad969ff04722f1b4aaff9c56e85152.jpg'} }/>
                        </View>
                        <View style={ myStyles.salesView }>
                            <Image style={myStyles.salesImage}
                                   source={ {uri:'http://p0.meituan.net/sjstpic/ec4c21447fa519b966302a8594e8990f121471.jpg'} }/>
                        </View>

                    </View>
                </View>

                <View style={ myStyles.unPayOrderLayout}>
                    <View style={ myStyles.unPayOrderFirst}>
                        <Text style={myStyles.contentText}>未支付订单1</Text>
                    </View>

                    <View style={ myStyles.unPayOrderOther}>
                        <Text style={myStyles.contentText}>未支付订单1</Text>
                    </View>

                </View>

                <View style={ myStyles.categoryLayout}>
                    <View style={myStyles.firstCategoryLayout}>
                        <View style={myStyles.firstCategory}>
                            <Text style={myStyles.contentCenterText}>我常买</Text>
                        </View>
                        <View style={myStyles.firstCategory}>
                            <Text style={myStyles.contentCenterText}>促销</Text>
                        </View>
                        <View style={myStyles.firstCategorySelected}>
                            <Text style={myStyles.contentCenterText}>家禽</Text>
                        </View>
                        <View style={myStyles.firstCategory}>
                            <Text style={myStyles.contentCenterText}>水产品</Text>
                        </View>
                        <View style={myStyles.firstCategory}>
                            <Text style={myStyles.contentCenterText}>猪肉</Text>
                        </View>
                    </View>

                    <View style={myStyles.secondCategoryLayout}>
                        <View style={myStyles.secondCategory}>
                            <Text style={myStyles.contentCenterText}>全部</Text>
                        </View>
                        <View style={myStyles.secondCategory}>
                            <Text style={myStyles.contentCenterText}>鸡腿</Text>
                        </View>
                        <View style={myStyles.selectedSecondCategory}>
                            <Text style={myStyles.contentCenterText}>鸡翅</Text>
                        </View>
                        <View style={myStyles.secondCategory}>
                            <Text style={myStyles.contentCenterText}>鸭肉</Text>
                        </View>
                        <View style={myStyles.secondCategory}>
                            <Text style={myStyles.contentCenterText}>其他</Text>
                        </View>
                    </View>
                </View>

            </View>
        );
    }
}

const myStyles = StyleSheet.create({
    banner: {
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#FA5C2F',
        height: 320
    },
    salesView: {
        flexDirection: 'column',
        marginLeft: 5,
        marginRight: 5,
        flex: 1,
        alignSelf: 'stretch',
        height: 180,
        justifyContent: 'center'
    },
    salesLayout: {
        flexDirection: 'column',
        alignItems: 'stretch',
        backgroundColor: '#ffffff',
        marginTop: 5,
        marginBottom: 5,
        marginLeft: 5,
        marginRight: 5
    },
    unPayOrderLayout: {
        flexDirection: 'column',
        alignItems: 'stretch',
        paddingTop: 10,
        paddingBottom: 10,
        paddingLeft: 10,
        paddingRight: 10,
        backgroundColor: '#dddddd'
    },
    unPayOrderFirst: {
        flexDirection: 'column',
        alignSelf: 'stretch',
        justifyContent: 'center',
        height: 80,
        borderTopLeftRadius: 15,
        borderTopRightRadius: 15,
        backgroundColor: '#FA5C2F',
        marginTop: 5,
        marginBottom: 5
    },
    unPayOrderOther: {
        flexDirection: 'column',
        alignSelf: 'stretch',
        justifyContent: 'center',
        height: 80,
        backgroundColor: '#FA5C2F',
        marginTop: 5,
        marginBottom: 5
    },
    categoryLayout: {
        flexDirection: 'column',
        justifyContent: 'flex-start',
        alignItems: 'stretch',
    },
    firstCategoryLayout: {
        flexDirection: 'row',
        borderBottomWidth: 1,
        borderBottomColor: '#cacaca',
    },
    firstCategory: {
        flexDirection: 'column',
        flex: 1,
        alignSelf: 'stretch',
        justifyContent: 'center',
        height: 50,
    },
    firstCategorySelected: {
        flexDirection: 'column',
        flex: 1,
        alignSelf: 'stretch',
        justifyContent: 'center',
        height: 50,
        borderBottomColor: '#FA5C2F',
        borderBottomWidth: 1.5
    },
    secondCategoryLayout: {
        flexDirection: 'row',
        flexWrap: 'wrap',
        justifyContent: 'space-between',
        alignItems: 'center',
        backgroundColor: '#eaeaea',
        padding: 5,
    },
    secondCategory: {
        justifyContent: 'center',
        margin: 5,
        width: 160,
        height: 50,
        borderTopLeftRadius: 25,
        borderTopRightRadius: 25,
        borderBottomLeftRadius: 25,
        borderBottomRightRadius: 25,
        alignSelf: 'center',
        backgroundColor: '#ffffff',
    },
    selectedSecondCategory: {
        justifyContent: 'center',
        margin: 5,
        width: 160,
        height: 50,
        borderTopLeftRadius: 25,
        borderTopRightRadius: 25,
        borderBottomLeftRadius: 25,
        borderBottomRightRadius: 25,
        alignSelf: 'center',
        backgroundColor: '#ffffff',
        borderWidth: 2,
        borderColor: '#FA5C2F'
    },
    divider: {
        alignSelf: 'stretch',
        backgroundColor: '#dddddd',
        height: 1
    },
    selectedDivider: {
        alignSelf: 'stretch',
        backgroundColor: '#FA5C2F',
        height: 1
    },
    headText: {
        fontSize: 64,
        alignSelf: 'center'
    },
    titleText: {
        fontSize: 32,
        alignSelf: 'center'
    },
    subTitleText: {
        fontSize: 24,
        alignSelf: 'center'
    },
    contentCenterText: {
        fontSize: 16,
        alignSelf: 'center'
    },
    contentText: {
        fontSize: 16,
        marginLeft: 20
    },
    bannerImage: {
        alignSelf: 'stretch',
        flex: 1,
        resizeMode: Image.resizeMode.stretch
    },
    salesImage: {
        alignSelf: 'stretch',
        flex: 1,
        resizeMode: Image.resizeMode.contain
    },
});

AppRegistry.registerComponent('Demo_ReactiveHelloWorld', () => Demo_ReactiveHelloWorld);
