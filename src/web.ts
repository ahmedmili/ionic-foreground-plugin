import { WebPlugin } from '@capacitor/core';

import type { ForegroundPlugin } from './definitions';


export class ForegroundPluginWeb extends WebPlugin implements ForegroundPlugin {
  bringToForeground(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
